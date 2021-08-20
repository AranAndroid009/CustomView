package com.aranandroid.customview.ui

import android.annotation.SuppressLint
import android.app.Activity
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

class ScrollActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)



        GlobalScope.launch {
            repeat(89) {

            }
        }

    }


}