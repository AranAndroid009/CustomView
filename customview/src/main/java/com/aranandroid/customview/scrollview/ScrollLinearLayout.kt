package com.aranandroid.customview.scrollview

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi


class ScrollLinearLayout (
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    LinearLayout(context!!, attrs, defStyleAttr) {


    private var lastX = 0
    private var lastY = 0

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_UP -> {
                val offX: Int = x - lastX
                val offY: Int = y - lastY
                animationScroll(getX() + offX, getY() + offY)
            }
        }
        return true
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    fun animationScroll(dx: Float, dy: Float) {
        val path = Path()
        path.moveTo(dx, dy)
        val objectAnimator = ObjectAnimator.ofFloat(this, "x", "y", path)
        objectAnimator.start()
    }
}