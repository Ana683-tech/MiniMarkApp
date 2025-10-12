package com.example.minimartapp.ui.screens.loginflow.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.minimartapp.R
import com.example.minimartapp.ui.theme.Styles.TextStyleRobotoRMediumSp14
import com.example.minimartapp.ui.theme.Styles.TextStyleRobotoRegularSp14
import com.example.minimartapp.ui.theme.Styles.textStyleRobotoBoldSp24
import com.example.minimartapp.ui.theme.Styles.textStyleRobotoRegularSp16
import com.example.minimartapp.ui.widgets.ButtonComposeView
import com.example.minimartapp.ui.widgets.DividerComposeView
import com.example.minimartapp.ui.widgets.InputTextFieldComposeView
import com.example.minimartapp.ui.widgets.PasswordValidationComposeView
import com.example.minimartapp.ui.widgets.TopBarComposeView
import com.example.minimartapp.ui.widgets.TypesButtons

@Composable
fun RegisterComposeView(
    onNavigateLogin: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComposeView("Register") {
//add accion de regreso
                onNavigateLogin.invoke()
            }
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("Create your account", style = textStyleRobotoBoldSp24)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Start shopping fresh groceries delivered to your door",
                    style = textStyleRobotoRegularSp16,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(28.dp))
                Row(modifier = Modifier.fillMaxWidth()) {

                    InputTextFieldComposeView(
                        modifier = Modifier.weight(1f),
                        label = "First Name",
                        placeholder = "John",
                        value = ""
                    ) { valueChange ->
                        //add input value
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    InputTextFieldComposeView(
                        modifier = Modifier.weight(1f),
                        label = "Last Name",
                        placeholder = "Doe",
                        value = ""
                    ) { valueChange ->
                        //add input value
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                InputTextFieldComposeView(
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier.fillMaxWidth(),
                    label = "Email",
                    placeholder = "john@example.com",
                    value = ""
                ) { valueChange ->
                    // loginViewModel.emailLoginInput = valueChange
                }

                Spacer(modifier = Modifier.height(16.dp))
                InputTextFieldComposeView(
                    keyboardType = KeyboardType.Phone,
                    modifier = Modifier.fillMaxWidth(),
                    label = "Phone Number",
                    placeholder = "+1(555)123-4567",
                    value = ""
                ) { valueChange ->
                    // loginViewModel.emailLoginInput = valueChange
                }

                Spacer(modifier = Modifier.height(16.dp))
                InputTextFieldComposeView(
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier.fillMaxWidth(),
                    label = "Password",
                    placeholder = "Create a password",
                    isPassword = true,
                    value = ""
                ) { valueChange ->
                    //loginViewModel.passwordLoginInput = valueChange
                }
                Spacer(modifier = Modifier.height(8.dp))
                PasswordValidationComposeView(isValid = false)
                Spacer(modifier = Modifier.height(8.dp))

                InputTextFieldComposeView(
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier.fillMaxWidth(),
                    label = " Confirm Password",
                    placeholder = "Confirm your password",
                    isPassword = true,
                    value = ""
                ) { valueChange ->
                    //loginViewModel.passwordLoginInput = valueChange
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {
                            //loginViewModel.checkBoxIsCheck = it
                        })
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("I gree to the Terms of Service and Privacy Policy ") // agregar un stilo de letra
                }
                Spacer(modifier = Modifier.height(24.dp))
                ButtonComposeView(
                    typesButtons = TypesButtons.Primary,
                    title = "Create Account",
                ) {
                }
                Spacer(modifier = Modifier.height(22.dp))
                DividerComposeView()
                Spacer(modifier = Modifier.height(22.dp))
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
                    Text("Already have an account? ", style = TextStyleRobotoRegularSp14)
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        "sign in",
                        style = TextStyleRobotoRMediumSp14,
                        color = Color(0xFF64B5F6),
                        modifier = Modifier.clickable(enabled = true, onClick = {
                            onNavigateLogin.invoke()
                        }))
                }
            }
        }
    }
}
