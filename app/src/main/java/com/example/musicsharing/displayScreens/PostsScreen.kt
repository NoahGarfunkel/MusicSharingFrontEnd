package com.example.musicsharing.displayScreens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.musicsharing.classes.Post
import com.example.musicsharing.classes.PostPayload

import com.example.musicsharing.modals.PostCreationDialog

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SocialMediaPostScreen(
    getPostFeed: suspend () -> List<Post>,
    sendPostInfo: suspend (PostPayload) -> Post
) {
    var posts = remember { mutableStateListOf<Post>() }
    var showDialog by remember { mutableStateOf(false) }


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
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            FloatingActionButton(
                onClick = { showDialog = true },
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }

        if (showDialog) {
            PostCreationDialog(setShowDialog = {
                showDialog = it
            },sendPostInfo

            )
        }
    }
}

/*
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SocialMediaPostScreen()
}

*/