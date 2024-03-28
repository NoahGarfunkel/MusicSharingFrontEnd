package com.example.musicsharing.displayScreens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostItem(username: String, postContent: String) {
    var likes by remember { mutableStateOf(0) }
    var isLiked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()// Makes the card take up the full width of its parent
            .height(150.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),

    ) {
        Column(
            modifier = Modifier
                .background(Color.White)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF309CA9))
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = username,
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 17.dp, start = 10.dp, bottom = 5.dp)


                )
            }
            Text(
                postContent,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f)
                    .background(Color.White)

            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 10.dp, end = 10.dp)
                    .drawWithContent {
                        drawContent() // Draw the original content of the Row
                        drawLine(
                            color = (Color(0xFF00889A)), // Set the color of the border
                            strokeWidth = 1.dp.toPx(), // Set the thickness of the border
                            start = Offset(x = 0f, y = 0f), // Start from the top left corner
                            end = Offset(x = size.width, y = 0f) // Draw to the top right corner
                        )
                    },

                verticalAlignment = Alignment.Bottom
            ) {

                // likes button
                IconButton(

                    onClick = {
                        likes += if (isLiked) -1 else 1 // Toggle the like state
                        isLiked = !isLiked
                    },
                    modifier = Modifier
                        .size(20.dp)
                ) {
                    Icon(
                        imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = "Edit Profile",
                        tint = Color(0xFF00889A)
                    )
                }

                Text(
                    text = "$likes",
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 3.dp)
                )
            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewPostItem() {
    PostItem(username = "Morgan Weltzer", postContent = "This is a test post.")
}