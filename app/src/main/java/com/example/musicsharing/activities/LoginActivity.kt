package com.example.musicsharing.activities

import PropertiesReader
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.musicsharing.retrofit.api.AccountsApi
import com.example.musicsharing.retrofit.AccountsRetrofit
import com.example.musicsharing.retrofit.api.WebApi
import com.example.musicsharing.retrofit.WebRetrofit
import com.example.musicsharing.ui.theme.MusicSharingTheme
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : ComponentActivity() {
    private lateinit var clientID: String
    private lateinit var clientSecret: String
    private val accountsApi = AccountsRetrofit().getInstance().create(AccountsApi::class.java)
    private val webApi = WebRetrofit().getInstance().create(WebApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PropertiesReader.init(this)
        clientID = PropertiesReader.getProperty("SPOTIFY_CLIENT_ID")
        clientSecret = PropertiesReader.getProperty("SPOTIFY_CLIENT_SECRET")
        val uri: Uri? = intent.data

        if (uri != null && uri.scheme == "music-sharing") {
            val code = uri.getQueryParameter("code")
            if (code != null)
                getToken(code)
        }

        setContent{
            MusicSharingTheme {
                LoginScreen()
            }
        }
    }

    @Composable
    fun LoginScreen(){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginButton(onClick = { authorization() })
        }
    }

    @Composable
    fun LoginButton(onClick: () -> Unit) {
        OutlinedButton(onClick = { onClick() }) {
            Text(
                text = "Login with Spotify",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

    private fun authorization() {
        val authCall = accountsApi.requestAuth(clientID, "code", "music-sharing://login")
        authCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(response.raw().request.url.toString()))
                    startActivity(browserIntent)
                } else {
                    // Log error information
                    Log.e("test", "API call failed with code: ${response.code()}")
                    // Handle the error if needed
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // Log failure information
                Log.e("test", "API call failed with exception: ${t.message}")
                // Handle the failure if needed
            }
        })
    }

    private fun getToken(code: String){
        val authString = "Basic " + Base64.encodeToString("$clientID:$clientSecret".toByteArray(), Base64.NO_WRAP)
        val tokenCall = accountsApi.getToken(authString, "application/x-www-form-urlencoded", "authorization_code", code, "music-sharing://login")

        tokenCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val responseJSON = JSONObject(response.body()?.string())
                    val token = responseJSON.getString("access_token")

                    getUserInfo(token)
                } else {
                    // Log error information
                    Log.e("test", "API call failed with code: ${response.errorBody()?.string()}")
                    // Handle the error if needed
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // Log failure information
                Log.e("test", "API call failed with exception: ${t.message}")
                // Handle the failure if needed
            }
        })
    }

    private fun getUserInfo(token: String){
        val userCall = webApi.getUser("Bearer $token")

        userCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    // Log success information
                    Log.d("test", "API call successful: ${response.body()?.string()}")
                } else {
                    // Log error information
                    Log.e("test", "API call failed with code: ${response.code()}")
                    // Handle the error if needed
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // Log failure information
                Log.e("test", "API call failed with exception: ${t.message}")
                // Handle the failure if needed
            }
        })
    }
}

