package com.example.musicsharing.retrofit.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BackendApi {
    @FormUrlEncoded
    @POST("user/register")
    fun saveUserInfo(
                 @Field(("userInfo")) userInfo:String
                 ): Call<ResponseBody>

}