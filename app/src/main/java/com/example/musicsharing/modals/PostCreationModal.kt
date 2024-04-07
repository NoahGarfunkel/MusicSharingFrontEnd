package com.example.musicsharing.modals

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.musicsharing.classes.Post
import com.example.musicsharing.classes.PostPayload
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostCreationDialog(
    setShowDialog: (Boolean) -> Unit,
    sendPostInfo: suspend (PostPayload) -> Post
) {

    var caption by remember { mutableStateOf("") }
    var song by remember { mutableStateOf("") }
    //var post by remember {mutableStateOf(Post)}

    val keyboardController = LocalSoftwareKeyboardController.current


    Dialog(onDismissRequest = { setShowDialog(false) }, properties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true
    )) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .fillMaxWidth()
                .height(500.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),

            ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .height(1000.dp)

            ) {

                Text(
                    text = "Create Post",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displaySmall
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Search for song",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.padding(8.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = song,
                    onValueChange = { song = it },
                    placeholder = { Text(text = "Search") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {keyboardController?.hide()})
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Caption",
                    style = MaterialTheme.typography.bodyLarge
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = caption,
                    onValueChange = { caption = it },
                    placeholder = { Text(text = "Add Caption") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {keyboardController?.hide()})
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(Color(0xFF309CA9)),
                        onClick = {
                            setShowDialog(false)
                        },
                        modifier = Modifier
                            .padding(start = 20.dp, top = 200.dp, end = 10.dp)
                            .height(35.dp)
                            .width(100.dp)

                    ) {
                        Text(text = "Cancel")

                    }
                    Button(
                        colors = ButtonDefaults.buttonColors(Color(0xFF309CA9)),
                        onClick = {
                            setShowDialog(false)
                            var post = PostPayload("",caption,"","","",song,0 )
                            CoroutineScope(Dispatchers.IO).launch {
                                // Call the suspend function within the coroutine
                                sendPostInfo(post)
                            }
                        },
                        modifier = Modifier
                            .padding(start = 50.dp, end = 10.dp)
                            .height(35.dp)
                            .width(100.dp)

                    ) {
                        Text(text = "Post")
                    }
                }
            }
        }
    }
}

/*@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewPostCreationModal() {
    PostCreationDialog()
}*/