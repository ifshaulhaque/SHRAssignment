package com.ifsha.shrassignment.screens.leaderboard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LeaderboardScreen(
    navController: NavController
) {
    Text("LeaderboardScreen")
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LeaderboardScreenPreview() {
    LeaderboardScreen(rememberNavController())
}