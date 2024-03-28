package com.example.musicsharing.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.musicsharing.navigation.AppNavigation
import com.example.musicsharing.ui.theme.MusicSharingTheme

class NavigationActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicSharingTheme {
                AppNavigation()
            }
        }
    }
}