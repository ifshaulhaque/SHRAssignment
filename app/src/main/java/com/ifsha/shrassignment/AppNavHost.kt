package com.ifsha.shrassignment

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ifsha.shrassignment.screens.authentication.AuthenticationScreen
import com.ifsha.shrassignment.screens.home.HomeScreen
import com.ifsha.shrassignment.screens.splash.SplashScreen
import kotlinx.serialization.Serializable

@Serializable
object Splash

@Serializable
object Authentication

@Serializable
object Home

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> {
            SplashScreen(navController)
        }

        composable<Authentication> {
            AuthenticationScreen(navController)
        }

        composable<Home> {
            HomeScreen(navController)
        }
    }
}