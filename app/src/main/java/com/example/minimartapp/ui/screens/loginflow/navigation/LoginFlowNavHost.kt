package com.example.minimartapp.ui.screens.loginflow.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minimartapp.ui.screens.loginflow.login.LoginComposeView
import com.example.minimartapp.ui.screens.loginflow.register.RegisterComposeView

@Composable
fun LoginFlowNavHost () {
    val  navcontroller = rememberNavController()


    NavHost(navController = navcontroller, startDestination = DestinationLogin){
        composable <DestinationLogin> {
            LoginComposeView{
                navcontroller.navigate(DestinationRegister)
            }
        }

        composable <DestinationRegister> {
            RegisterComposeView()
        }
    }
}