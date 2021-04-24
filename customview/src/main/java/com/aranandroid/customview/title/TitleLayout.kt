package com.aranandroid.customview.title

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout


class TitleLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    LinearLayout(context, attrs, defStyleAttr) {

    init {
        orientation= VERTICAL
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(context: Context?) : this(context, null) {

    }
}