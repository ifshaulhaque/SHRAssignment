package com.ifsha.shrassignment.screens.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ifsha.shrassignment.screens.home.HomeMain

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Text("ProfileScreen")
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}