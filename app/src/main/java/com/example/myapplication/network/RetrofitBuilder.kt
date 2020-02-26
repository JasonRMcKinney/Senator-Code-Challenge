package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    fun getRetrofit(baseURL: String): GovtrackService {

        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GovtrackService::class.java)
    }
}


    // rohit.lagu@cognizant.com