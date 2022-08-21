package com.example.newsapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.zip.Inflater

class myAdapter(val context : Context,val  article:List<Article>) :RecyclerView.Adapter<myAdapter.myViewHolder>() {
    //So we have to inherit the myAdapter class to RecyclerView having a class Adapter of generic type which holder our myViewHolder.
    // Here we can implement the required methods

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        // ViewHolder create krta hai or usko store krwata hai
        // Sabse pahle ham view banaenge with the help og layout inflater
        // Inflater hmari xml file ko java object me convert krta hai

        val inflater = LayoutInflater.from(context)
        val view =inflater.inflate(R.layout.item_view,parent,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        //yaha ham data ko bind kr rahe hai/

        holder.txtTitle.text = article[position].title
        holder.txtContent.text =article[position].description
        Glide.with(context).load(article[position].urlToImage).into(holder.newsImage)

    }

    override fun getItemCount(): Int {
        return article.size
    }

    class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        // I have created the myViewHolder class so that to holder the data items and inherit to recyclerView.
        // RecyclerView holder ViewHolder class and its constructor.

        //mujhe bar bar findViewById use na krna pde islie maine ek hi jagah isko define kr dia hai
        var newsImage =itemView.findViewById<ImageView>(R.id.img)
        var txtTitle =itemView.findViewById<TextView>(R.id.newsTitle)
        var txtContent =itemView.findViewById<TextView>(R.id.newsDescription)


    }

}

