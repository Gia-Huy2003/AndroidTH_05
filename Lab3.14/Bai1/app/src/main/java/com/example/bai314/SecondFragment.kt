package com.example.bai314

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val cart = mutableListOf<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lấy danh sách sản phẩm trong giỏ hàng từ arguments
        val cartItems = arguments?.getStringArray("cartItems")?.toMutableList() ?: mutableListOf()
        cart.addAll(cartItems)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Thiết lập adapter với callback xóa sản phẩm
        recyclerView.adapter = ProductAdapter(cart, null) { product ->
            // Hiển thị dialog xác nhận xóa sản phẩm khỏi giỏ hàng
            AlertDialog.Builder(requireContext())
                .setTitle("Xóa khỏi giỏ hàng")
                .setMessage("Bạn có muốn xóa $product khỏi giỏ hàng?")
                .setPositiveButton("Có") { dialog, _ ->
                    // Xóa sản phẩm khỏi giỏ hàng
                    cart.remove(product)
                    // Cập nhật adapter
                    recyclerView.adapter?.notifyDataSetChanged()
                    Snackbar.make(view, "$product đã xóa khỏi giỏ hàng", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Không", null)
                .show()
        }
    }
}
