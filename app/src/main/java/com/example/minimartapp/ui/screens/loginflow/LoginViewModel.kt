package com.example.minimartapp.ui.screens.loginflow

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var emailLoginInput by mutableStateOf("")
    var passwordLoginInput by mutableStateOf("")
    var checkBoxIsCheck by mutableStateOf(false)


}