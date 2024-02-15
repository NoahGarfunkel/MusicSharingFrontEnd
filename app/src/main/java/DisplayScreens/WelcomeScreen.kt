//package DisplayScreens
//
//import android.content.res.Configuration
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.MailOutline
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//@Preview(
//    showBackground = true,
//    name = "Light Mode"
//)
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MusicSharingAppHome() {
//    Scaffold(
//        topBar = { AppTopBar() },
//        bottomBar = { AppBottomNavigation() }
//    ) { innerPadding ->
//        BodyContent(Modifier.padding(innerPadding))
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppTopBar() {
//    TopAppBar(
//        title = { Text("Music Sharing App") },
//
//
//    )
//}
//
//@Composable
//fun BodyContent(modifier: Modifier = Modifier) {
//    Column(modifier = modifier
//        .fillMaxSize()
//        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
//        WelcomeMessage()
//        MusicGroupsSection()
//        // Add more content here as needed
//    }
//}
//
//@Composable
//fun WelcomeMessage() {
//    Text("Welcome back, [Username]!", style = MaterialTheme.typography.h5)
//    Spacer(modifier = Modifier.height(16.dp))
//}
//
//@Composable
//fun MusicGroupsSection() {
//    Text("Join Music Groups", style = MaterialTheme.typography.h6)
//    // Implement the music groups list/grid here
//}
//
//@Composable
//fun AppBottomNavigation() {
//    BottomNavigation(elevation = 12.dp) {
//        BottomNavigationItem(
//            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
//            selected = false,
//            onClick = { /* Handle home click */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Filled.MailOutline, contentDescription = "Messages") },
//            selected = false,
//            onClick = { /* Handle messages click */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
//            selected = false,
//            onClick = { /* Handle search click */ }
//        )
//    }
//}
//
//@Composable
//fun BottomNavigationItem(icon: () -> Unit, selected: Boolean, onClick: () -> Unit) {
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MusicSharingAppHome()
//}
