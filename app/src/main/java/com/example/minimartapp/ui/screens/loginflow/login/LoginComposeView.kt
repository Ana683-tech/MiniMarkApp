package com.example.minimartapp.ui.screens.loginflow.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.minimartapp.ui.screens.loginflow.navigation.DestinationRegister

@Composable
fun LoginComposeView (navController: NavController) {
    Box(modifier = Modifier.background(Color.Cyan).fillMaxSize().clickable(onClick = {
        navController.navigate(DestinationRegister)
    }))
}