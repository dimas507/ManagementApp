package com.mccm.managementapp.presentation.views.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor()  : ViewModel() {

    //Username
    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrMsg: MutableState<String> = mutableStateOf("")

    //Confirm Password
    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isconfirmPassword: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrMsg: MutableState<String> = mutableStateOf("")

    //Email
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    //Password
    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordlErrMsg: MutableState<String> = mutableStateOf("")

    //NIF
    var nif: MutableState<String> = mutableStateOf("")
    var isnifValid: MutableState<Boolean> = mutableStateOf(false)
    var nifErrMsg: MutableState<String> = mutableStateOf("")

    //Button
    var isEnableSignupButton = false

    //functions

    fun ValidateUsername(){
        if (username.value.length >=5){
            isUsernameValid.value = true
            usernameErrMsg.value = ""
        }
        else{
            isUsernameValid.value = false
            usernameErrMsg.value = "You must enter at least 5 characters"
        }
        enableSignUpButton()
    }

    fun validateEmail(){
        if(Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrMsg.value = ""
        }
        else {
            isEmailValid.value = false
            emailErrMsg.value = "Email not valid "
        }
        enableSignUpButton()
    }

    fun validatePassword(){
        if(password.value.length >= 6){
            isPasswordValid.value = true
            passwordlErrMsg.value = ""
        }
        else {
            passwordlErrMsg.value = "You must enter at least 6 characters"

        }
        enableSignUpButton()
    }

    fun ValidateConfirmPassword(){
        if (password.value == confirmPassword.value){
            isconfirmPassword.value = true
            confirmPasswordErrMsg.value = ""
        }
        else{
            isconfirmPassword.value = false
            confirmPasswordErrMsg.value = "Passwords don't match"
        }
        enableSignUpButton()
    }

    fun enableSignUpButton(){
        isEnableSignupButton = isEmailValid.value == true &&
                isPasswordValid.value == true &&
                isconfirmPassword.value == true &&
                isUsernameValid.value == true
    }
}