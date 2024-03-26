package com.example.musicsharing.classes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
)

//screens
{
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Filled.Home
    )
    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Filled.AccountCircle
    )
    object Posts: BottomBarScreen(
        route = "posts",
        title = "Posts",
        icon = Icons.Filled.MailOutline
    )

}
