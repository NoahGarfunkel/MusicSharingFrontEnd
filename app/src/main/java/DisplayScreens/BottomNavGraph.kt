package DisplayScreens


import GreetingsScreen
import SocialMediaPostScreen
import android.os.Build
import androidx.annotation.RequiresApi
import model.BottomBarScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.musicsharing.MainActivity

@RequiresApi(Build.VERSION_CODES.O)
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
            SocialMediaPostScreen()
        }
    }
}



