import java.util.Calendar

// Step 1: Define Models
data class Post(val imageURL: String, val spotifyId: String, val title: String, val userId: Int, val timestamp: Calendar)

data class User(val displayName: String, val spotifyId: String)

data class Comment(val comment: String, val postId: Int, val userId: Int)
// Step 2: Implement Post Generation Logic
fun createPost(imageURL: String, spotifyId: String, title: String, userId: Int): Post {
    val timestamp = Calendar.getInstance()
    return Post(imageURL, spotifyId, title, userId, timestamp)
}

fun newUser(displayName: String, spotifyId: String): User{
    return User(displayName, spotifyId)
}

fun createComment(comment: String, postId: Int, userId: Int): Comment{
    return Comment(comment, postId, userId)
}
// Step 3 & 4: Integration with UI and Display Generated Posts
fun main() {
}
