package com.example.myapplication.network

import com.example.myapplication.model.Payload
import retrofit2.http.GET
import retrofit2.http.Query

//https://www.govtrack.us/api/v2/role?current=true&role_type=senator
interface GovtrackService {

    @GET("api/v2/role")
    suspend fun getSenators(@Query("current") current: String, @Query("role_type") roleType: String) : Payload
}