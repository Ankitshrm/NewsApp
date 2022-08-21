package com.example.newsapp

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=338786a455c743f9b9984aa6baa469d8 (Particular country and session)
//https://newsapi.org/v2/everything?q=tesla&from=2022-07-20&sortBy=publishedAt&apiKey=338786a455c743f9b9984aa6baa469d8  (All Info)


const val BASE_URL ="https://newsapi.org/"
const val API_KEY ="338786a455c743f9b9984aa6baa469d8"

interface NewsInterface {
    //Yaha methods define karenge

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeading(@Query("country") country:String,@Query("page") page:Int): Call<News>
}

object NewsService{
        val newsInstance :NewsInterface
        init {
            val retrofit =Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            newsInstance= retrofit.create(NewsInterface::class.java)
        }
}
