package com.example.musicsharing.modals

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.rememberNavController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostCreationDialog() {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        val navController = rememberNavController()
        Dialog(onDismissRequest = { showDialog = false }) {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(300.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),

                ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
//                        .height(1500.dp)

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                            var searchText by remember { mutableStateOf("") }
                            TextField(
                                value = searchText,
                                onValueChange = { searchText = it },
                                placeholder = {
                                    Text(
                                        "Search for songs",
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(80.dp)
                                            .padding(top = 0.dp)
                                    )},
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(top = 10.dp, start = 15.dp, bottom = 5.dp)
                                    .height(45.dp)
                                    .width(10.dp)
                            )
                            Button(
                                onClick = { /* Handle search button click here */ },
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, top  = 8.dp)
                                    .height(35.dp)
                                    .width(80.dp)
                            ) {
                                Text(
                                    "Search",
                                    fontSize = 8.sp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                )
                            }
                        }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .drawWithContent {
                                drawContent()
                                drawLine(
                                    color = (Color(0xFF00889A)),
                                    strokeWidth = 1.dp.toPx(),
                                    start = Offset(x = 0f, y = 0f),
                                    end = Offset(x = size.width, y = 0f)
                                )
                            },
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Button(
                            colors = ButtonDefaults.buttonColors(Color(0xFF309CA9)),
                            onClick = {
                                showDialog = false
                            },
                            modifier = Modifier
                                .padding(start = 20.dp, top = 180.dp, end = 10.dp)
                                .height(35.dp)
                                .width(100.dp)

                        ) {
                            Text(text = "Cancel")

                        }
                        Button(
                            colors = ButtonDefaults.buttonColors(Color(0xFF309CA9)),
                            onClick = {
                                showDialog = false
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
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewPostCreationModal() {
    PostCreationDialog()
}
