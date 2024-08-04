package com.example.apiproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

//mention Api end point in this class

interface qutesinterface {
    @Headers("x-rapidapi-key:7209c637fcmsh0883b0e694ed139p1e9770jsn6bdfa66b7225","x-rapidapi-host:quotes85.p.rapidapi.com" )
    @GET("/author?author=Albert-Einstein")


    fun getData(): Call<Author_model>
}