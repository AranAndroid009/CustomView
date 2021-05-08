package com.aranandroid.customview.utils

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aranandroid.customview.squareview.SquareTextEdit
import com.blankj.utilcode.util.CloneUtils
import com.blankj.utilcode.util.ThreadUtils

/**
 * 记得添加这俩插件
 * apply plugin: 'kotlin-android-extensions'
 * apply plugin: 'kotlin-kapt'
 */


@InverseBindingAdapter(attribute = "value", event = "valueAttrChanged")
fun SquareTextEdit.getValue(): String? {
    return this.edittext.text?.toString()
}


@BindingAdapter("value", requireAll = false)
fun SquareTextEdit.setValue(text: MutableLiveData<String>?) {
    var squ = this
    ThreadUtils.runOnUiThread(Runnable { squ.valueme = text?.value })

    text?.let {
        if (!it.hasObservers()) {
            it.observe(this.context as LifecycleOwner, Observer { level ->
                ThreadUtils.runOnUiThread(Runnable {
                    val selectionStart = squ.edittext.getSelectionStart()
                    squ.valueme = level
                    squ.edittext.setSelection(selectionStart)
                })
            })
        }
    }

}

@BindingAdapter("valueAttrChanged", requireAll = false)
fun SquareTextEdit.valueAttrChanged(inverseBindingListener: InverseBindingListener?) {
    this.edittext.addTextChangedListener(object : TextWatcher {
        var temp :String? = null
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            if (TextUtils.isEmpty(s)) {
                temp = ""
            }else temp = CloneUtils.deepClone(s.toString(), String::class.java)
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (!temp!!.equals(s.toString())) {
                inverseBindingListener?.onChange()
            }
            if (TextUtils.isEmpty(s)) {
                temp = ""
            }else temp = CloneUtils.deepClone(s.toString(), String::class.java)
        }
    })

}




