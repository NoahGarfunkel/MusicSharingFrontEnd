package com.example.musicsharing.classes

data class PostPayload (
    val artistName: String,
    val caption: String,
    val imageUrl: String,
    val spotifyId: String,
    val spotifyUrl: String,
    val trackName: String,
    var userId: Int
)


