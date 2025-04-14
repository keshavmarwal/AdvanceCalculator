package com.example.advancecalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UnitCustomGridAdapter(private val context: Context, private val imglist: List<Int>,private val  titlelist: List<String>): BaseAdapter() {
    var inflater: LayoutInflater? = null
    override fun getCount(): Int {
        return titlelist.size
    }

    override fun getItem(position: Int): Any? {
        return titlelist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView =  convertView
        if(inflater== null) inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if(convertView == null) {
            convertView = inflater!!.inflate(R.layout.custom_grid_unitconverter, null)
        }
        val imageView = convertView!!.findViewById<ImageView>(R.id.img)
        val textView = convertView!!.findViewById<TextView>(R.id.text)

        imageView.setImageResource(imglist[position])
        textView.text = titlelist[position]
        return convertView

    }
}