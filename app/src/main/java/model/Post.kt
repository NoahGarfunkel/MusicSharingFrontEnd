package model

data class Post(
    val content: String,
    val username: String,
    val profilePictureId: Int, // Assuming you're using resource IDs for profile pictures
    val timestamp: String // Store timestamp as a string for simplicity
)
