package com.example.newsapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class myAdapter(val songs:List<Song>) :RecyclerView.Adapter<myAdapter.myViewHolder>() {
    //So we have to inherit the myAdapter class to RecyclerView having a class Adapter of generic type which holder our myViewHolder.
    // Here we can implement the required methods

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        // ViewHolder create krta hai or usko store krwata hai
        // Sabse pahle ham view banaenge with the help og layout inflater
        // Inflater hmari xml file ko java object me convert krta hai

        val inflater = LayoutInflater.from(parent.context)
        val view =inflater.inflate(R.layout.item_view,parent,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        //yaha ham data ko bind kr rahe hai/

        holder.txtTitle.text = songs[position].title
        holder.txtContent.text =songs[position].content
        var color ="#CCCCCC"
        if(position%2==0){
            color="#425160"
        }
        holder.container.setBackgroundColor(Color.parseColor(color))
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        // I have created the myViewHolder class so that to holder the data items and inherit to recyclerView.
        // RecyclerView holder ViewHolder class and its constructor.

        //mujhe bar bar findViewById use na krna pde islie maine ek hi jagah isko define kr dia hai
        var txtTitle =itemView.findViewById<TextView>(R.id.title)
        var txtContent =itemView.findViewById<TextView>(R.id.content)
        var container=itemView.findViewById<LinearLayout>(R.id.container)

    }

}

