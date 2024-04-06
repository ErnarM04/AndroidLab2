package com.example.androidlab2.network

import com.example.androidlab2.model.Cat
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

object ApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance = retrofit.create(ApiService::class.java)

    interface ApiService {
        @Headers("X-Api-Key: 2iHq7eP9412jDfWBYtV7nAXFQkvoXoA78IVuzum0")
        @GET("cats")
        fun getCatByName(@Query("name") name: String): Call<List<Cat>>
    }

}