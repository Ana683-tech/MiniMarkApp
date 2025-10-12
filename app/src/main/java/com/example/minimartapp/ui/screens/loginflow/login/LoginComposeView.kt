package com.example.minimartapp.ui.screens.loginflow.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.minimartapp.R
import com.example.minimartapp.ui.screens.loginflow.LoginViewModel
import com.example.minimartapp.ui.theme.Styles.TextStyleRobotoRMediumSp14
import com.example.minimartapp.ui.theme.Styles.TextStyleRobotoRegularSp14
import com.example.minimartapp.ui.theme.Styles.textStyleRobotoBoldSp24
import com.example.minimartapp.ui.theme.Styles.textStyleRobotoRegularSp16
import com.example.minimartapp.ui.widgets.ButtonComposeView
import com.example.minimartapp.ui.widgets.InputTextFieldComposeView
import com.example.minimartapp.ui.widgets.TopBarComposeView
import com.example.minimartapp.ui.widgets.TypesButtons

@Composable
fun LoginComposeView(
    loginViewModel: LoginViewModel = hiltViewModel(),
    onNavigateClick:()-> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComposeView("MiniMart")
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text("Welcome back", style = textStyleRobotoBoldSp24)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Singn to your account to continue shopping",
                style = textStyleRobotoRegularSp16,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(28.dp))
            InputTextFieldComposeView(
                label = "Email",
                placeholder = "Enter your Email",
                value = loginViewModel.emailLoginInput,
            ) { valueChange ->
                loginViewModel.emailLoginInput = valueChange
            }

            Spacer(modifier = Modifier.height(16.dp))
            InputTextFieldComposeView(
                label = "Password",
                placeholder = "Enter your Password",
                isPassword = true,
                value = loginViewModel.passwordLoginInput,
            ) { valueChange ->
                loginViewModel.passwordLoginInput = valueChange
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = loginViewModel.checkBoxIsCheck,
                    onCheckedChange = {
                        loginViewModel.checkBoxIsCheck = it
                    })
                Spacer(modifier = Modifier.width(4.dp))
                Text("Remember me") // agregar un stilo de letra
            }
            Spacer(modifier = Modifier.height(16.dp))
            ButtonComposeView(
                typesButtons = TypesButtons.Primary,
                title = "Sign In",
            ) {
                onNavigateClick.invoke()
            }
            Spacer(modifier = Modifier.weight(1f))
            ButtonComposeView(
                typesButtons = TypesButtons.Secondary,
                title = "Continue With Google",
                icon = R.drawable.ic_google,
            ) {

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {
                Text("Don't have a account? ", style = TextStyleRobotoRegularSp14)
                Spacer(modifier = Modifier.width(3.dp))
                Text("Sign up", style = TextStyleRobotoRMediumSp14, color = Color(0xFF64B5F6))
            }
        }
    }
}