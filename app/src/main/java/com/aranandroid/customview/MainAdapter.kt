package com.aranandroid.customview

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class MainAdapter(layoutResId: Int,data: MutableList<String>? = null) : BaseQuickAdapter<String,BaseViewHolder>(layoutResId,data) {

    constructor(data: MutableList<String>? = null) : this(R.layout.item_main,data){}

    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.content,item)
    }

}

