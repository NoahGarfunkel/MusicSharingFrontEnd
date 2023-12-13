package com.example.musicsharing

import PropertiesReader
import android.os.Bundle
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
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class LoginActivity : ComponentActivity() {
    private lateinit var clientID: String

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
    embeddedServer(Netty, host = "127.0.0.1", port = 8080) {
        routing {
            get("/callback") {
                call.respondText("Hello, world!")
            }
        }
    }.start(wait = true)
    /*val client = HttpClient(CIO)
    val response: HttpResponse = client.get("https://accounts.spotify.com/authorize?")
    client.close()*/
}