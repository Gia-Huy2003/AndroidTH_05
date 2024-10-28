package com.example.bai314

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import android.widget.Button

class FirstFragment : Fragment(R.layout.fragment_first) {

    private val products = listOf("Máy tính", "Súng", "Giường", "Đạn", "Nhà")
    private val cart = mutableListOf<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = ProductAdapter(products, { product ->
            // Hiển thị Dialog xác nhận thêm sản phẩm vào giỏ hàng
            AlertDialog.Builder(requireContext())
                .setTitle("Thêm vào giỏ hàng")
                .setMessage("Bạn có muốn thêm $product vào giỏ hàng?")
                .setPositiveButton("Có") { dialog, _ ->
                    // Thêm sản phẩm vào giỏ hàng
                    cart.add(product)
                    Snackbar.make(view, "$product đã thêm vào giỏ hàng", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Không", null)
                .show()
        }, { product ->
            // Hiển thị Dialog xác nhận xóa sản phẩm khỏi giỏ hàng
            AlertDialog.Builder(requireContext())
                .setTitle("Xóa khỏi giỏ hàng")
                .setMessage("Bạn có muốn xóa $product khỏi giỏ hàng?")
                .setPositiveButton("Có") { dialog, _ ->
                    // Xóa sản phẩm khỏi giỏ hàng
                    cart.remove(product)
                    Snackbar.make(view, "$product đã xóa khỏi giỏ hàng", Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("Không", null)
                .show()
        })

        // Nút điều hướng tới giỏ hàng
        view.findViewById<Button>(R.id.buttonViewCart).setOnClickListener {
            // Tạo Bundle để chứa dữ liệu giỏ hàng
            val bundle = Bundle().apply {
                putStringArray("cartItems", cart.toTypedArray()) // Đưa danh sách giỏ hàng vào Bundle
            }
            // Điều hướng đến SecondFragment với Bundle
            findNavController().navigate(R.id.secondFragment, bundle)
        }
    }
}
