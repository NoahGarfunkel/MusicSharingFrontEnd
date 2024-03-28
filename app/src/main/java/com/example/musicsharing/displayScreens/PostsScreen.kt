package com.example.musicsharing.displayScreens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SocialMediaPostScreen() {
    val posts = remember { mutableStateListOf<String>() }
    var postText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00889A))

    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            itemsIndexed(posts.reversed()) { index, post ->
                PostItem(username = "User123", postContent = post)
            }
        }
        Row(
            modifier = Modifier
                .background(Color.White)
                .navigationBarsPadding()
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            OutlinedTextField(
                value = postText,
                onValueChange = { postText = it },
                label = { Text("What's on your mind?") },
                modifier = Modifier
                    .width(250.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    if (postText.isNotBlank()) {
                        posts.add(postText)
                        postText = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF00889A)),
//                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 20.dp,top = 10.dp)

//                    .align(Alignment.End)
//                    .align(Alignment.C)
            ) {
                Text("Post")
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SocialMediaPostScreen()
}

