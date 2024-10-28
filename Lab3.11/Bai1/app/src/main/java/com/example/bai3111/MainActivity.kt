package com.example.bai3111

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var gestureDetector: GestureDetectorCompat
    private lateinit var inputField: EditText
    private lateinit var showButton: Button
    private lateinit var deleteButton: Button
    private lateinit var outputText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the GestureDetector
        gestureDetector = GestureDetectorCompat(this, this)

        // Find views by ID
        inputField = findViewById(R.id.inputField)
        showButton = findViewById(R.id.showButton)
        deleteButton = findViewById(R.id.deleteButton)
        outputText = findViewById(R.id.outputText)

        // Set onClickListener for the show button
        showButton.setOnClickListener {
            val inputText = inputField.text.toString()
            outputText.text = inputText
        }

        // Set onClickListener for the delete button
        deleteButton.setOnClickListener {
            inputField.text.clear()  // Clear the EditText
            outputText.text = ""     // Clear the TextView
        }
    }

    // Handle touch events
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event!!) || super.onTouchEvent(event)
    }

    // Implement GestureDetector methods
    override fun onDown(event: MotionEvent): Boolean {
        return true
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        Toast.makeText(this, "Bạn vừa vuốốt màn hình!", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        Toast.makeText(this, "Bạn đang nhấn giữ!", Toast.LENGTH_SHORT).show()
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        e1?.let {
            // Có thể xử lý e1 ở đây
        }
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        // Nothing to do here
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        Toast.makeText(this, "Bạn vừa chạm vào màn hình!", Toast.LENGTH_SHORT).show()
        return true
    }
}
