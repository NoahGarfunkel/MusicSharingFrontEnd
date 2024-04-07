package com.example.musicsharing.displayScreens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicsharing.classes.Post

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SocialMediaPostScreen(getPostFeed: suspend () -> List<Post>) {
    var posts = remember { mutableStateListOf<Post>() }
    var postText by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val data = getPostFeed()
        posts.addAll(data)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFF3E8))

    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            itemsIndexed(posts) { index, post ->
                PostItem(postContent = post)
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
                    /*if (postText.isNotBlank()) {
                        posts.add(postText)
                        postText = ""
                    }*/
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF00889A)),
                modifier = Modifier
                    .padding(start = 20.dp,top = 10.dp)
            ) {
                Text("Post")
            }
        }
    }
}

/*
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SocialMediaPostScreen(::getPostFeed)
}*/

