package com.example.musicsharing.retrofit.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface BackendApi {

    @Headers("Content-Type: application/json")
    @POST("user/register")
    fun saveUserInfo(
        @Body() userInfo: String
    ): Call<ResponseBody>

    @GET("user/exists/{spotifyId}")
    fun userExists(@Path("spotifyId") spotifyId: String): Call<Boolean>

}

