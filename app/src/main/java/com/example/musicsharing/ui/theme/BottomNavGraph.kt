package com.example.musicsharing.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musicsharing.classes.BottomBarScreen
import com.example.musicsharing.displayScreens.SocialMediaPostScreen
import profileScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomNavGraph(navController : NavHostController) {
    NavHost (
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
//        composable(route = BottomBarScreen.Home.route){
//            HomeScreen()
//        }
        composable(route = BottomBarScreen.Profile.route){
            profileScreen()
        }
        composable(route = BottomBarScreen.Posts.route){
            SocialMediaPostScreen()
        }
    }
}





