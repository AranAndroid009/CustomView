package com.aranandroid.customview.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.aranandroid.customview.R
import com.aranandroid.customview.squareview.SquareTextView
import com.aranandroid.customview.ui.square.AFragment
import com.aranandroid.customview.ui.square.BFragment
import kotlinx.android.synthetic.main.activity_square_moreview.*
import kotlinx.android.synthetic.main.activity_square_textview.*
import kotlinx.android.synthetic.main.item_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SquareMoreActivity : FragmentActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_moreview)

        square_text_image.imageView.setOnClickListener{v ->
            Toast.makeText(this ,"click",Toast.LENGTH_SHORT).show()
        }
        fragment_top.fragments = linkedMapOf(Pair(R.id.f, AFragment()),Pair(R.id.h, BFragment()))
        fragment_top.changeItme={group, checkedId ->
            Log.e("TAG", "onCreate: "+checkedId )
        }
    }


}