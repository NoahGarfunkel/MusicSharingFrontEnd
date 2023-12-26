package com.example.musicsharing

import PropertiesReader
import android.os.Bundle
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
import com.example.musicsharing.ui.theme.MusicSharingTheme
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote

class LoginActivity : ComponentActivity() {
    private lateinit var clientID: String
    private var spotifyAppRemote: SpotifyAppRemote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

    private fun authorization(){
        PropertiesReader.init(this)
        clientID = PropertiesReader.getProperty("SPOTIFY_CLIENT_ID")
        val connectionParams = ConnectionParams.Builder(clientID)
            .setRedirectUri("http://localhost:3000/login")
            .showAuthView(true)
            .build()

        SpotifyAppRemote.connect(this, connectionParams, object : Connector.ConnectionListener {
            override fun onConnected(appRemote: SpotifyAppRemote) {
                spotifyAppRemote = appRemote
                Log.d("LoginActivity", "Connected! Yay!")
            }

            override fun onFailure(throwable: Throwable) {
                Log.e("LoginActivity", throwable.message, throwable)
            }
        })
    }

    override fun onStop() {
        super.onStop()
        spotifyAppRemote?.let {
            SpotifyAppRemote.disconnect(it)
        }
    }
}

