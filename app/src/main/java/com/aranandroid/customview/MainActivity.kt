package com.aranandroid.customview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aranandroid.customview.ui.SquareActivity
import kotlinx.android.synthetic.main.item_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<RecyclerView>(R.id.listview)
        listView.layoutManager = LinearLayoutManager(this)
        val mainAdapter = MainAdapter(arrayListOf("ShapeTextView"))
        mainAdapter.setOnItemClickListener { adapter, view, position ->
            val item = mainAdapter.getItem(position)
            when(item){
                "ShapeTextView" -> startActivity(Intent(this,SquareActivity::class.java))
            }

        }
        listView.adapter = mainAdapter

    }
}