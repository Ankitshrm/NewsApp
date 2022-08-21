package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView:RecyclerView
    lateinit var adapter: myAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ids()
        getNews()
    }

    private fun getNews() {
        val news =NewsService.newsInstance.getHeading("in",1)
        news.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news =response.body()
                if(news!=null){
                    Log.d("MYCODE",news.toString())
                    adapter = myAdapter(this@MainActivity,news.articles)
                    myRecyclerView.adapter=adapter
                    myRecyclerView.layoutManager =LinearLayoutManager(this@MainActivity) //Setting up the type of recyclerView

                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MYCODE","Error ara hai bhai")
            }
        })
    }

    private fun ids() {
        myRecyclerView=findViewById(R.id.myRecyclerView)
    }
}