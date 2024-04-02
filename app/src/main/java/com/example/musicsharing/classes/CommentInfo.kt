package com.example.musicsharing.classes
import java.time.LocalDateTime

data class CommentInfo (
    val comment: String,
    val postId: Int,
    val userId: Int,
    val commentId: Int,
    val createdOn: LocalDateTime,
    val userName: String
)