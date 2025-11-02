package com.ifsha.shrassignment.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ifsha.shrassignment.Authentication
import com.ifsha.shrassignment.Home
import com.ifsha.shrassignment.R
import com.ifsha.shrassignment.Splash

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    LaunchedEffect(splashViewModel.isUserLoggedIn) {
        if (splashViewModel.isUserLoggedIn.value) {
            navController.navigate(Home) {
                popUpTo<Splash> { inclusive = true }
            }
        } else {
            navController.navigate(Authentication) {
                popUpTo<Splash> { inclusive = true }
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}