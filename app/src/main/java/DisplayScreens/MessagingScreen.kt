//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.outlined.FavoriteBorder
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.musicsharing.R
//import java.time.Instant
//import java.time.ZoneId
//import java.time.format.DateTimeFormatter
//import java.util.*
//
//@RequiresApi(Build.VERSION_CODES.O)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SocialMediaPostScreen() {
//    Surface(color = MaterialTheme.colorScheme.background) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            // Header with profile picture, username, and timestamp
//            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Image(
//                        painter = painterResource(id = R.drawable.profile_picture), // Replace with your drawable resource
//                        contentDescription = "Profile picture",
//                        modifier = Modifier
//                            .size(48.dp)
//                            .clip(CircleShape)
//                    )
//                    Text(
//                        text = "@username", // Dynamic username
//                        style = MaterialTheme.typography.titleMedium,
//                        modifier = Modifier.padding(start = 8.dp)
//                    )
//                }
//
//                // Dynamic timestamp
//                Text(
//                    text = getCurrentTimestamp(),
//                    style = MaterialTheme.typography.bodySmall,
//                    textAlign = TextAlign.Right,
//                    modifier = Modifier.align(Alignment.CenterVertically)
//                )
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Text field for typing a post
//            var postText by remember { mutableStateOf("") }
//            OutlinedTextField(
//                value = postText,
//                onValueChange = { postText = it },
//                label = { Text("What's on your mind?") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Footer with Like button
//            FooterWithLikeButton()
//        }
//    }
//}
//
//// Function to get the current timestamp in a readable format
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun getCurrentTimestamp(): String {
//    val instant = Instant.now()
//    val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm").withZone(ZoneId.systemDefault())
//    return formatter.format(instant)
//}
//
//
//@Composable
//fun FooterWithLikeButton(modifier: Modifier = Modifier) {
//    var isLiked by remember { mutableStateOf(false) } // Tracks whether the post is liked
//    var likesCount by remember { mutableIntStateOf(100) } // Start with a default number of likes, for example, 100
//
//    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically){
//        Text("$likesCount", Modifier.padding(end = 8.dp)) // Display the number of likes
//
//        IconButton(
//            onClick = {
//                isLiked = !isLiked
//                if (isLiked) {
//                    likesCount++ // Increase likes count if post is liked
//                } else {
//                    likesCount-- // Decrease likes count if post is unliked
//                }
//            }
//        ) {
//            Icon(
//                imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
//                contentDescription = "Like",
//                tint = if (isLiked) Color.Red else Color.Gray
//            )
//        }
//    }
//
//}
//
//
//
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SocialMediaPostScreen()
//}

//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.outlined.FavoriteBorder
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.musicsharing.R
//import java.time.Instant
//import java.time.ZoneId
//import java.time.format.DateTimeFormatter
//import java.util.*
//
//@RequiresApi(Build.VERSION_CODES.O)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SocialMediaPostScreen() {
//    val posts = remember { mutableStateListOf<String>() } // Stores the posts
//    var postText by remember { mutableStateOf("") }
//
//    Surface(color = MaterialTheme.colorScheme.background) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            // Header with profile picture, username, and timestamp
//            Header()
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Input field for typing a new post
//            OutlinedTextField(
//                value = postText,
//                onValueChange = { postText = it },
//                label = { Text("What's on your mind?") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Button(
//                onClick = {
//                    if (postText.isNotBlank()) {
//                        posts.add(0, postText)
//                        postText = ""
//                    }
//                },
//                modifier = Modifier.align(Alignment.End)
//            ) {
//                Text("Post")
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Display posts
//            LazyColumn(modifier = Modifier.fillMaxSize()) {
//                items(posts) { post ->
//                    Text(post, modifier = Modifier.padding(8.dp))
//                    Divider()
//                }
//            }
//        }
//    }
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun Header() {
//    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Image(
//                painter = painterResource(id = R.drawable.profile_picture), // Replace with your drawable resource
//                contentDescription = "Profile picture",
//                modifier = Modifier
//                    .size(48.dp)
//                    .clip(CircleShape)
//            )
//            Text(
//                text = "@username", // need to make dynamic
//                style = MaterialTheme.typography.titleMedium,
//                modifier = Modifier.padding(start = 8.dp)
//            )
//        }
//
//        // Dynamic timestamp
//        Text(
//            text = getCurrentTimestamp(),
//            style = MaterialTheme.typography.bodySmall,
//            textAlign = TextAlign.Right,
//            modifier = Modifier.align(Alignment.CenterVertically)
//        )
//    }
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun getCurrentTimestamp(): String {
//    val instant = Instant.now()
//    val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm").withZone(ZoneId.systemDefault())
//    return formatter.format(instant)
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SocialMediaPostScreen()
//}

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialMediaPostScreen() {
    val posts = remember { mutableStateListOf<String>() }
    var postText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        // Display posts in reverse order, newest at the top
        LazyColumn(modifier = Modifier.weight(1f)) {
            itemsIndexed(posts.reversed()) { index, post ->
                PostItem(post)
            }
        }

        // Input field and button for creating a new post at the bottom
        Column(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = postText,
                onValueChange = { postText = it },
                label = { Text("What's on your mind?") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    if (postText.isNotBlank()) {
                        posts.add(postText)
                        postText = ""
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Post")
            }
        }
    }
}

@Composable
fun PostItem(post: String) {
    Card(modifier = Modifier.padding(8.dp), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Text(post, modifier = Modifier.padding(8.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun getCurrentTimestamp(): String {
    val instant = Instant.now()
    val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm").withZone(ZoneId.systemDefault())
    return formatter.format(instant)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SocialMediaPostScreen()
}

