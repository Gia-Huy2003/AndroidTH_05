package com.example.bai3121

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Danh sách các URL hình ảnh
        val imageUrls = listOf(
            "https://images.pexels.com/photos/1445093/pexels-photo-1445093.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", // Ảnh game 1
            "https://images.pexels.com/photos/1444473/pexels-photo-1444473.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", // Ảnh game 2
            "https://images.pexels.com/photos/1366912/pexels-photo-1366912.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", // Ảnh game 3
            "https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwzNjUyOXwwfDF8c2VhcmNofDIxfHxmb3J0aWF8ZW58MHx8fHwxNjY4MjA1MjE4&ixlib=rb-1.2.1&q=80&w=1080", // Giữ nguyên ảnh số 4
            "https://images.pexels.com/photos/1624499/pexels-photo-1624499.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"  // Ảnh game 4
        )


        recyclerView = findViewById(R.id.RecyclerView) // Sửa ID thành "RecyclerView"
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cài đặt adapter cho RecyclerView
        imageAdapter = ImageAdapter(imageUrls)
        recyclerView.adapter = imageAdapter
    }
}
