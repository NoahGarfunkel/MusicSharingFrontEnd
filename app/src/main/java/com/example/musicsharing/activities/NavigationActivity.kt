package com.example.musicsharing.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musicsharing.classes.FollowPayload
import com.example.musicsharing.classes.Post
import com.example.musicsharing.constants.SharedPreferencesConstants
import com.example.musicsharing.displayScreens.GreetingsScreen
import com.example.musicsharing.navigation.AppNavigation
import com.example.musicsharing.retrofit.BackendRetrofit
import com.example.musicsharing.retrofit.api.BackendApi
import com.example.musicsharing.ui.theme.MusicSharingTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NavigationActivity : ComponentActivity() {
    private val backendApi = BackendRetrofit().getInstance().create(BackendApi::class.java)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicSharingTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = "AppNavigation"
                ) {
                    composable("login") {
                        LoginActivity()
                    }
                    composable("home") {
                        GreetingsScreen()
                    }
                    composable("AppNavigation") {
                        AppNavigation(::signOut, ::addFriend, ::getPostFeed)
                    }
                }
            }
        }
    }

    private fun signOut(){
        val sharedPreferences = getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(SharedPreferencesConstants.KEY_LOGGED_IN, false).apply()
        sharedPreferences.edit().remove(SharedPreferencesConstants.KEY_SPOTIFY_ID).apply()
        sharedPreferences.edit().remove(SharedPreferencesConstants.KEY_USER_ID).apply()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun addFriend(enteredName: String){
        val sharedPreferences = getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getInt(SharedPreferencesConstants.KEY_USER_ID, 0)
        val followPayload = FollowPayload(enteredName, userId)
        backendApi.followUser(followPayload).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    Log.d("addFriendResponse", "friend $enteredName was added successfully, with code: ${response.code()}")
                } else {
                    Log.e("addFriendResponse", "getUser request failed with code: ${response.errorBody()?.string()}")
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("addFriendResponse", "getUser request failed: ${t.message}")
            }
        })
    }

    private suspend fun getPostFeed(): List<Post> {
        val sharedPreferences = getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getInt(SharedPreferencesConstants.KEY_USER_ID, 0)
        return withContext(Dispatchers.IO) {
            try {
                val response = backendApi.getPostFeed(userId).execute()
                if (response.isSuccessful && response.body() != null){
                    response.body()
                } else {
                    Log.e("getPostFeed", "getPostFeed request failed with code: ${response.code()}")
                    emptyList<Post>()
                }
            } catch (e: Exception) {
                Log.e("getPostFeed", "getPostFeed request failed: ${e.message}")
                emptyList<Post>()
            }!!
        }

    }
}