package com.example.bai314

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val products: List<String>,
    private val onAddToCart: ((String) -> Unit)?,
    private val onRemoveFromCart: ((String) -> Unit)?
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.size

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: String) {
            (itemView as TextView).text = product
            itemView.setOnClickListener {
                // Gọi hàm để thêm sản phẩm vào giỏ hàng
                onAddToCart?.invoke(product)
            }
            itemView.setOnLongClickListener {
                // Gọi hàm để xóa sản phẩm khỏi giỏ hàng
                onRemoveFromCart?.invoke(product)
                true
            }
        }
    }
}
