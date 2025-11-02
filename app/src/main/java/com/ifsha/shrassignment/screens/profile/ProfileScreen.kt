package com.ifsha.shrassignment.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ifsha.shrassignment.Authentication
import com.ifsha.shrassignment.R
import com.ifsha.shrassignment.Splash
import com.ifsha.shrassignment.screens.home.HomeMain

@Composable
fun ProfileScreen(
    navController: NavController,
    mainNavController: NavController,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = profileViewModel.user.value?.email ?: "example@gmail.com",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .border(
                    width = 1.dp,
                    color = Color.DarkGray
                )
        )

        Text(
            text = stringResource(R.string.sign_out),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Red,
            modifier = Modifier.fillMaxWidth()
                .clickable{
                    profileViewModel.signOut()
                    navController.popBackStack(route = HomeMain, inclusive = true)
                    mainNavController.navigate(Splash) {
                        popUpTo<Authentication> {
                            inclusive = true
                        }
                    }
                }
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController(), rememberNavController())
}