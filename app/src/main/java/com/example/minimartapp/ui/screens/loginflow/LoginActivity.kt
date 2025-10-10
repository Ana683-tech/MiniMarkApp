package com.example.minimartapp.ui.screens.loginflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.minimartapp.ui.screens.loginflow.login.LoginComposeView
import com.example.minimartapp.ui.screens.loginflow.navigation.LoginFlowNavHost
import com.example.minimartapp.ui.theme.MiniMartAppTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniMartAppTheme {
                //  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> }
                LoginFlowNavHost()
            }
        }
    }
}