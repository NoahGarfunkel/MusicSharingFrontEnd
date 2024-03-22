package com.example.musicsharing.activities

import android.content.Context
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import com.example.musicsharing.ui.theme.MusicSharingTheme

private const val KEY_LOGGED_IN = "isLoggedIn"
class TestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            MusicSharingTheme {
                TestScreen()
            }
        }
    }

    @Composable
    fun TestScreen(){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("This is a test screen")

            // Add a button
            Button(onClick = {
                val sharedPreferences = getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
                sharedPreferences.edit().putBoolean(KEY_LOGGED_IN, false).apply()
            }) {
                Text("Sign Out")
            }
        }
    }

}

