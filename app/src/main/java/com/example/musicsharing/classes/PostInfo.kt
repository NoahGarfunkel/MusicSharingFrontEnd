package com.example.musicsharing.classes

import java.time.LocalDateTime

data class PostInfo (
    val artistName: String,
    val caption: String,
    val imageUrl: String,
    val spotifyId: String,
    val spotifyUrl: String,
    val trackName: String,
    val comment: String,
    val postId: Int,
    val commentId: Int,
    val createdOn: LocalDateTime,
    val userName: String
)

