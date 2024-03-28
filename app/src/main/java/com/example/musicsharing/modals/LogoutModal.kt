package com.example.musicsharing.modals

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LogoutModal(username: String, postContent: String) {
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
                    text = "Are You Sure You Want To Log Out?",
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 17.dp, start = 50.dp, bottom = 5.dp)



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
                    .padding(bottom = 8.dp)
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
                Text(
                    text = "Likes",
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 5.dp, start = 10.dp, bottom = 2.dp)
                )
            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewLogoutModal() {
    LogoutModal(username = "Morgan Weltzer", postContent = "This is a test post.")
}
