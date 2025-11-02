package com.ifsha.shrassignment.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ifsha.shrassignment.screens.home_main.HomeMainScreen
import com.ifsha.shrassignment.screens.leaderboard.LeaderboardScreen
import com.ifsha.shrassignment.screens.profile.ProfileScreen
import kotlinx.serialization.Serializable

@Composable
fun HomeNavHost(
    navHostController: NavHostController,
    mainNavController: NavController
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeMain
    ) {
        composable<HomeMain> {
            HomeMainScreen(navHostController)
        }

        composable<Leaderboard> {
            LeaderboardScreen(navHostController)
        }

        composable<Profile> {
            ProfileScreen(navHostController, mainNavController)
        }
    }
}

@Serializable
object HomeMain {
    val id: Int = 1
}

@Serializable
object Leaderboard {
    val id: Int = 2
}

@Serializable
object Profile {
    val id: Int = 3
}