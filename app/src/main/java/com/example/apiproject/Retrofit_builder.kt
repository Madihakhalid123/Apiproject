package com.example.apiproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_builder {
    val quoteApi = "https://quotes85.p.rapidapi.com/"

    fun getInstance() : Retrofit {

        return  Retrofit.Builder()
            .baseUrl(quoteApi)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}