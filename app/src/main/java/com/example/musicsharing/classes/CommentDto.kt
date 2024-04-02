package com.example.musicsharing.classes
import java.time.LocalDateTime
data class CommentDto(
    val comment: String,
    val commentId: Int,
    val createdOn: LocalDateTime,
    val userId: Int,
    val userName: String,
)