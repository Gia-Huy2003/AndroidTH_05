package com.example.bai3112

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailField: EditText
    private lateinit var phoneField: EditText
    private lateinit var submitButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by ID
        emailField = findViewById(R.id.emailField)
        phoneField = findViewById(R.id.phoneField)
        submitButton = findViewById(R.id.submitButton)
        resultText = findViewById(R.id.resultText)

        // Set onClickListener for the submit button
        submitButton.setOnClickListener {
            validateInput()
        }
    }

    private fun validateInput() {
        val email = emailField.text.toString()
        val phone = phoneField.text.toString()

        // Check email validity
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email không hợp lệ!", Toast.LENGTH_SHORT).show()
            return
        }

        // Check phone validity
        if (!phone.matches("\\d+".toRegex())) {
            Toast.makeText(this, "Số điện thoại chỉ chứa ký tự số!", Toast.LENGTH_SHORT).show()
            return
        }

        // If both inputs are valid
        resultText.text = "Email và số điện thoại hợp lệ!"
    }
}