package com.mccm.managementapp.presentation.views.login

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases):ViewModel() {

    //Email
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    //Password
    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordlErrMsg: MutableState<String> = mutableStateOf("")

    //Button
    var isEnableLoginButton = false

    private val _loginflow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginflow: StateFlow<Response<FirebaseUser>?> = _loginflow

    val currentUser = authUseCases.getCurrentUser()

    init {
        if (currentUser != null){
            _loginflow.value = Response.Success(currentUser)
        }
    }

    //functions
    fun validateEmail(){
        if(Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrMsg.value = ""
        }
        else {
            isEmailValid.value = false
            emailErrMsg.value = "Email not valid "
            }
        enableLogButton()
    }
    fun validatePassword(){
        if(password.value.length >= 6){
            isPasswordValid.value = true
            passwordlErrMsg.value = ""
        }
        else {
            passwordlErrMsg.value = "You must enter at least 6 characters"
        }
        enableLogButton()
    }
    fun login() = viewModelScope.launch {
        _loginflow.value = Response.Loading
        val result = authUseCases.login(email.value, password.value)
        _loginflow.value = result
    }
    fun enableLogButton(){
        isEnableLoginButton = isEmailValid.value == true && isPasswordValid.value == true
    }
}
