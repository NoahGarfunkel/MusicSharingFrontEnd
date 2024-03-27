package com.example.musicsharing.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musicsharing.displayScreens.HomeScreen
import com.example.musicsharing.displayScreens.SocialMediaPostScreen
import com.example.musicsharing.ui.theme.MusicSharingTheme

class NavigationActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicSharingTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        LoginActivity()
                    }
                    composable("posts") {
                        SocialMediaPostScreen()
                    }
                    composable("home") {
                        HomeScreen(navController = navController)
                    }
                }
            }
        }
    }
}
