package com.example.musicsharing.retrofit.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface WebApi {
    @GET("v1/me")
    fun getUser(@Header("Authorization") authorization: String): Call<ResponseBody>
}