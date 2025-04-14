package com.example.advancecalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListCustomAdapter(context: Context ,private val itemList:List<ListCustom>):
    ArrayAdapter<ListCustom>(context,0,itemList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
      val currentItem = itemList[position]
        val view =convertView?: LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        val imgView : ImageView = view.findViewById(R.id.imglistitem)
        val titleView : TextView = view.findViewById(R.id.titellistitem)
        val descView : TextView = view.findViewById(R.id.desclistitem)

        imgView.setImageResource(currentItem.imgid)
        titleView.text = currentItem.title
        descView.text = currentItem.description
        return view;
    }
}