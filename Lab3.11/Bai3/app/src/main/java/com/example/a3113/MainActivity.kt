package com.example.a3113

import android.graphics.Color
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var gestureDetector: GestureDetectorCompat
    private lateinit var mainLayout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.mainLayout)
        gestureDetector = GestureDetectorCompat(this, this)

        // Thiết lập listener cho cử chỉ
        mainLayout.setOnTouchListener { v, event ->
            gestureDetector.onTouchEvent(event)
            true
        }
    }

    // Implement GestureDetector methods
    override fun onDown(event: MotionEvent): Boolean {
        return true
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        // Kiểm tra cử chỉ vuốt lên hoặc xuống
        if (e1 != null) {
            val diffY = e2.y - e1.y
            if (Math.abs(diffY) > Math.abs(velocityX) && Math.abs(diffY) > 100) {
                if (diffY < 0) {
                    // Vuốt lên
                    mainLayout.setBackgroundColor(Color.YELLOW)
                } else {
                    // Vuốt xuống
                    mainLayout.setBackgroundColor(Color.RED)
                }
                return true
            }
        }
        return false
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        // Chạm một lần
        mainLayout.setBackgroundColor(Color.BLUE)
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        // Không làm gì khi nhấn giữ
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        // Không làm gì khi nhấn
    }
}