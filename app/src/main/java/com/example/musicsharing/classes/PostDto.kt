package com.example.musicsharing.classes
import java.time.LocalDateTime
data class PostDto (
    val artistName: String,
    val caption: String,
    val comments: List<CommentDto>,
    val createdOn: LocalDateTime,
    val imageUrl: String,
    val spotifyId: String,
    val spotifyUrl: String,
    val trackName: String,
    val userId: Int,
    val userName: String
)