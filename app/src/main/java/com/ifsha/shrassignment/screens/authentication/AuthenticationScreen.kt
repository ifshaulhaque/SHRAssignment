package com.ifsha.shrassignment.screens.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ifsha.shrassignment.Home
import com.ifsha.shrassignment.R
import com.ifsha.shrassignment.Splash

@Composable
fun AuthenticationScreen(
    navController: NavController,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        authenticationViewModel.isLoggedIn.collect {
            if (it) {
                navController.navigate(Home) {
                    popUpTo<Splash> { inclusive = true }
                }
            }
        }
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            label = { Text(text = stringResource(R.string.email)) },
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it},
            label = { Text(text = stringResource(R.string.password)) },
        )

        Button(
            onClick = {
                authenticationViewModel.signIn(email.trim(), password.trim())
            }
        ) {
            Text(
                text = stringResource(R.string.sign_in)
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AuthenticationScreenPreview() {
    AuthenticationScreen(rememberNavController())
}