// Step 1: Define Post Model
data class Post(val imageURL: String, val spotifyId: String, val title: String, val userId: Int, val timestamp: Long)

// Step 2: Implement Post Generation Logic
fun generatePost(imageURL: String, spotifyId: String, title: String, userId: Int): Post {
        val timestamp = System.currentTimeMillis()
        return Post(imageURL, spotifyId, title, userId, timestamp)
        }

// Step 3 & 4: Integration with UI and Display Generated Posts (for console application)
        fun main() {
        // Simulate user input or generate data
        val imageURL = "https://example.com/image.jpg"
        val spotifyId = "spotify:track:4uLU6hMCjMI75M1A2tKUQC"
        val title = "My Awesome Playlist"
        val userId = 123 // Example user ID

        // Generate a post
        val generatedPost = generatePost(imageURL, spotifyId, title, userId)

        // Display the generated post
        println("New Post:")
        println("Image URL: ${generatedPost.imageURL}")
        println("Spotify ID: ${generatedPost.spotifyId}")
        println("Title: ${generatedPost.title}")
        println("User ID: ${generatedPost.userId}")
        println("Timestamp: ${generatedPost.timestamp}")
        }
