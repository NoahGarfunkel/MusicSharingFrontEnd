package com.example.musicsharing.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BackendRetrofit() {

    private val baseUrl = "https://localhost:44323/"

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .build()
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}