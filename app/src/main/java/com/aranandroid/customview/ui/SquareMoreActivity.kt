package com.aranandroid.customview.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.aranandroid.customview.R
import com.aranandroid.customview.ui.square.*
import kotlinx.android.synthetic.main.activity_square_moreview.*

class SquareMoreActivity : FragmentActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_moreview)

        square_text_image.imageView.setOnClickListener{v ->
            Toast.makeText(this ,"click",Toast.LENGTH_SHORT).show()
        }
        fragment_bottom.fragments = linkedMapOf(Pair(R.id.a, AFragment()),Pair(R.id.b, BFragment()),Pair(R.id.c, CFragment()),Pair(R.id.d, DFragment()))
        fragment_bottom.changeItme={group, checkedId ->
            Log.e("TAG", "onCreate: "+checkedId )
        }

        fragment_top.fragments = linkedMapOf(Pair(R.id.f, FFragment()),Pair(R.id.h, HFragment()))

    }


}