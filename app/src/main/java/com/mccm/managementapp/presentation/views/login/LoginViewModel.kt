package com.mccm.managementapp.presentation.views.login

import android.provider.ContactsContract.CommonDataKinds.Email
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

    //State Form
    var state by mutableStateOf(LoginState())
        private set

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    //Email
    var isEmailValid by mutableStateOf(false)
        private set
    var emailErrMsg by mutableStateOf("")
        private set

    //Password
    var isPasswordValid by mutableStateOf(false)
        private set
    var passwordlErrMsg by mutableStateOf("")
        private set

    //Button
    var isEnableLoginButton = false

    //Login Response
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    val currentUser = authUseCases.getCurrentUser()

    init {
        if (currentUser != null){
            loginResponse = Response.Success(currentUser)
        }
    }

    //functions
    fun validateEmail(){
        if(Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            isEmailValid = true
            emailErrMsg = ""
        }
        else {
            isEmailValid = false
            emailErrMsg = "Email not valid "
            }
        enableLogButton()
    }
    fun validatePassword(){
        if(state.password.length >= 6){
            isPasswordValid = true
            passwordlErrMsg = ""
        }
        else {
            passwordlErrMsg = "You must enter at least 6 characters"
        }
        enableLogButton()
    }
    fun login() = viewModelScope.launch {
        loginResponse = Response.Loading
        val result = authUseCases.login(state.email, state.password)
        loginResponse = result
    }
    fun enableLogButton(){
        isEnableLoginButton = isEmailValid == true && isPasswordValid == true
    }
}
