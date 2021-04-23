package com.aranandroid.customview.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aranandroid.customview.R
import com.aranandroid.customview.squareview.SquareTextView
import kotlinx.android.synthetic.main.activity_square_textview.*
import kotlinx.android.synthetic.main.item_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SquareActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_textview)
        hollow_rectangle.squareView.setCorners(floatArrayOf(20F,10F,30F,0F))
        square_constranint_layout.squareView.setCorner(20F)
        SquareTextImage.imageView.setOnClickListener{v ->
            Toast.makeText(this ,"click",Toast.LENGTH_SHORT).show()
        }

        GlobalScope.launch {
            repeat(8900909) {
                val findViewById = findViewById<RadioButton>(radio2.checkedRadioButtonId)
                println("pppid"+findViewById?.text)
                delay(1000)
            }
        }
    }


}