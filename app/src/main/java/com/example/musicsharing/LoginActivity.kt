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
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicsharing.ui.theme.MusicSharingTheme
import androidx.compose.ui.Modifier
import kotlinx.coroutines.*

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;

class LoginActivity : ComponentActivity() {
    private lateinit var clientID: String
    private var spotifyAppRemote: SpotifyAppRemote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            MusicSharingTheme {
                PropertiesReader.init(this)
                clientID = PropertiesReader.getProperty("SPOTIFY_CLIENT_ID")
                LoginScreen(clientID)
            }
        }
    }

    override fun onStart() {
        super.onStart()
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
                // Now you can start interacting with App Remote
                connected()
            }

            override fun onFailure(throwable: Throwable) {
                Log.e("LoginActivity", throwable.message, throwable)
                // Something went wrong when attempting to connect! Handle errors here
            }
        })
    }

    private fun connected() {
        // Then we will write some more code here.
    }

    override fun onStop() {
        super.onStop()
        // Aaand we will finish off here.
    }
}

@Composable
fun LoginScreen(clientID: String){
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginButton(onClick = {
                CoroutineScope(Dispatchers.Default).launch{
                    authorization(clientID)
                }
        })
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

suspend fun authorization(clientID: String){

}