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

