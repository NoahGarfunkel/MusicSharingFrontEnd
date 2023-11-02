package com.example.musicsharing

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

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MusicSharingTheme {
                LoginScreen()
            }
        }
    }
}

@Preview
@Composable
fun LoginScreen(){
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginButton(onClick = {

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