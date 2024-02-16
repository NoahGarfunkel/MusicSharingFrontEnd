package DisplayScreens


import GreetingsScreen
import com.example.musicsharing.ui.theme.BottomBarScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.musicsharing.MainActivity

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(BottomBarScreen.Home.route) {
            GreetingsScreen()
        }
        composable(BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
//        composable(BottomBarScreen.Settings.route) {
//            SettingsScreen()
//        }
        composable(BottomBarScreen.Messaging.route) {
            MessagingScreen()
        }
    }
}
