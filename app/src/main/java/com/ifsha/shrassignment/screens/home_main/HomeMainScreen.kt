package com.ifsha.shrassignment.screens.home_main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeMainScreen(
    navController: NavController
) {
    Text("HomeMainScreen")
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeMainScreenPreview() {
    HomeMainScreen(rememberNavController())
}