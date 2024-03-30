package com.example.musicsharing.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musicsharing.displayScreens.GreetingsScreen
import com.example.musicsharing.displayScreens.SocialMediaPostScreen
import com.example.musicsharing.navigation.AppNavigation
import com.example.musicsharing.ui.theme.MusicSharingTheme

private const val KEY_LOGGED_IN = "isLoggedIn"

class NavigationActivity : ComponentActivity() {
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
                    composable("posts") {
                        SocialMediaPostScreen()
                    }
                    composable("home") {
                        GreetingsScreen()
                    }
                    composable("AppNavigation") {
                        AppNavigation(::signOut)
                    }
                }
            }
        }
    }

    private fun signOut(){
        val sharedPreferences = getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(KEY_LOGGED_IN, false).apply()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}