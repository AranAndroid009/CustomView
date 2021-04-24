package com.aranandroid.customview.title

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.aranandroid.customview.R
import com.aranandroid.customview.squareview.SquareView

class TitleView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    BaseTitle(context!!, attrs, defStyleAttr) {

    val view:View
    init {
        view = LayoutInflater.from(context).inflate(R.layout.view_title, this, true)

    }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(context: Context?) : this(context, null) {

    }
}