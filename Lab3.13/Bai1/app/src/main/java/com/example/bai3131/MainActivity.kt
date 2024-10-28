package com.example.bai3131

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber: EditText
    private lateinit var buttonCheck: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextNumber)
        buttonCheck = findViewById(R.id.buttonCheck)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCheck.setOnClickListener {
            val number = editTextNumber.text.toString().toIntOrNull()
            textViewResult.text = if (number != null) {
                if (number % 2 == 0) {
                    "Even Number"
                } else {
                    "Odd Number"
                }
            } else {
                "Please enter a valid number"
            }
        }
    }
}