package model

//data class Post(
//    val id: Int,
//    val user: User,
//    val hasImage: Boolean,
//    val imageURL: String?,
//    val numComments: Int,
////    val numLikes: Int,
//    val date: String,
//    val text: String,
//
//    )

data class Post(
    val content: String,
    val username: String,
    val profilePictureId: Int, // Assuming you're using resource IDs for profile pictures
    val timestamp: String // Store timestamp as a string for simplicity
)
