package com.aranandroid.customview.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.aranandroid.customview.R
import com.aranandroid.customview.squareview.SquareTextView
import kotlinx.android.synthetic.main.activity_square_textview.*

class SquareActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_textview)
        hollow_rectangle.squareView.setCorners(floatArrayOf(20F,10F,30F,0F))
        square_constranint_layout.squareView.setCorner(20F)
    }
}