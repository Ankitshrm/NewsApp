package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ids()

        val songObj:MutableList<Song> = mutableListOf<Song>()
        songObj.add(Song("HELLO","HELLOHELLOHELLOHELLO"))
        songObj.add(Song("WORLD","WORLDWORLDWORLDWORLD"))
        songObj.add(Song("QWERT","QWERTQWERTQWERTQWERT"))
        songObj.add(Song("ABCDE","ABCDEABCDEABCDEABCDE"))
        songObj.add(Song("POIUY","POIUYPOIUYPOIUYPOIUY"))
        songObj.add(Song("ASDFG","ASDFGASDFGASDFGASDFG"))
        songObj.add(Song("MNBVC","MNBVCMNBVCMNBVCMNBVC"))

        myRecyclerView.adapter=myAdapter(songObj) //Passing the data to Adpater
        myRecyclerView.layoutManager =LinearLayoutManager(this) //Setting up the type of recyclerView


    }

    private fun ids() {
        myRecyclerView=findViewById(R.id.myRecyclerView)
    }
}