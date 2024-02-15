package com.example.musicsharing.retrofit.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BackendApi {
    @FormUrlEncoded
    @POST("user/info/save")
    fun saveUserInfo(
                 @Field(("userInfo")) grantType:String
                 ): Call<ResponseBody>

}