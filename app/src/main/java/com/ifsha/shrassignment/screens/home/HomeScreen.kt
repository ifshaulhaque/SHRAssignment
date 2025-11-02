package com.ifsha.shrassignment.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ifsha.shrassignment.R

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    var selectedNavigationBar by remember { mutableStateOf(HomeMain.id) }
    var homeNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                NavigationBarItem(
                    selected = selectedNavigationBar == HomeMain.id,
                    onClick = {
                        selectedNavigationBar = HomeMain.id
                        homeNavController.navigate(HomeMain) {
                            popUpTo<HomeMain> { inclusive = true }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.home).uppercase(),
                            fontWeight = FontWeight.Bold,
                        )
                    }
                )

                NavigationBarItem(
                    selected = selectedNavigationBar == Leaderboard.id,
                    onClick = {
                        selectedNavigationBar = Leaderboard.id
                        homeNavController.navigate(Leaderboard) {
                            popUpTo<Leaderboard> { inclusive = true }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Face,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.leaderboard).uppercase(),
                            fontWeight = FontWeight.Bold,
                        )
                    }
                )

                NavigationBarItem(
                    selected = selectedNavigationBar == Profile.id,
                    onClick = {
                        selectedNavigationBar = Profile.id
                        homeNavController.navigate(Profile) {
                            popUpTo<Profile> { inclusive = true }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.profile).uppercase(),
                            fontWeight = FontWeight.Bold,
                        )
                    }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            HomeNavHost(
                navHostController = homeNavController,
                mainNavController = navController
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}