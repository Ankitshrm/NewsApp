package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class myAdapter() :RecyclerView.Adapter<myViewHolder>() {
    //So we have to inherit the myAdapter class to RecyclerView having a class Adapter of generic type which holder our myViewHolder.
    // Here we can implement the required methods

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        // ViewHolder create krta hai or usko store krwata hai
        // Sabse pahle ham view banaenge with the help og layout inflater
        // Inflater hmari xml file ko java object me convert krta hai

        val inflater = LayoutInflater.from(parent.context)
        val view =inflater.inflate(R.layout.item_view,parent,false)
        return view
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    // I have created the myViewHolder class so that to holder the data items and inherit to recyclerView.
    // RecyclerView holder ViewHolder class and its constructor.

}