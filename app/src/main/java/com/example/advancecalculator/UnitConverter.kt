package com.example.advancecalculator

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UnitConverter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_unit_converter)
        val gridView = findViewById<GridView>(R.id.gridView)

        val itemName : List<String> = listOf("Temp","Length","Weight")
        val image: List<Int> = listOf(R.drawable.temprature,
            R.drawable.length,
            R.drawable.weight)

        val adapter = UnitCustomGridAdapter(this,image,itemName)
        gridView.adapter = adapter
//
//        gridView.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(
//                this@GridViewActivity,
//                "You Clicked on ${itemName[position]}",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }
}