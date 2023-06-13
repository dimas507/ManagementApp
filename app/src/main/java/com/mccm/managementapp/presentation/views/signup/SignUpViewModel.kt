package com.mccm.managementapp.presentation.views.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.domain.model.User
import com.mccm.managementapp.domain.use_cases.auth.AuthUseCases
import com.mccm.managementapp.domain.use_cases.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authUseCases: AuthUseCases, private val usersUseCases: UsersUseCases)  : ViewModel() {

    //Username
    var name:MutableState<String> = mutableStateOf("")
    var isnameValid: MutableState<Boolean> = mutableStateOf(false)
    var nameErrMsg: MutableState<String> = mutableStateOf("")

    var lastname:MutableState<String> = mutableStateOf("")
    var islastnameValid: MutableState<Boolean> = mutableStateOf(false)
    var lastnameErrMsg: MutableState<String> = mutableStateOf("")

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

    //Address
    var address: MutableState<String> = mutableStateOf("")
    var isaddressValid: MutableState<Boolean> = mutableStateOf(false)
    var addressErrMsg: MutableState<String> = mutableStateOf("")

    //Birthday
    var birthday: MutableState<String> = mutableStateOf("")

    //Access type
    var accessType: MutableState<String> = mutableStateOf("")
    var isaccessTypeValid: MutableState<Boolean> = mutableStateOf(false)
    var accessTypeErrMsg: MutableState<String> = mutableStateOf("")

    //Gender
    var gender: MutableState<String> = mutableStateOf("")
    var isgenderValid: MutableState<Boolean> = mutableStateOf(false)
    var genderErrMsg: MutableState<String> = mutableStateOf("")

    //School name
    var schoolName: MutableState<String> = mutableStateOf("")
    var isschoolNameValid: MutableState<Boolean> = mutableStateOf(false)
    var schoolNameErrMsg: MutableState<String> = mutableStateOf("")

    //Button
    var isEnableSignupButton = false

    //functions
    fun isValidString(input: String): Boolean {
        val pattern = Regex("^[a-zA-Z ]+$")
        return pattern.matches(input)
    }

    fun ValidateName(){

        if (name.value.length >=3 && isValidString(name.value)){
            isnameValid.value = true
            nameErrMsg.value = ""
        }
        else{
            isnameValid.value = false
            nameErrMsg.value = "You must enter at least 3 characters in the name and only use letters"
        }
        enableSignUpButton()
    }
    fun ValidateLastname(){

        if (lastname.value.length >=3 && isValidString(lastname.value)){
            islastnameValid.value = true
            lastnameErrMsg.value = ""
        }
        else{
            islastnameValid.value = false
            lastnameErrMsg.value = "You must enter at least 3 characters in the lastname and only use letters"
        }
        enableSignUpButton()
    }

    fun ValidateNIF(){

        if (nif.value.length >=4){
            isnifValid.value = true
            nifErrMsg.value = ""
        }
        else{
            isnifValid.value = false
            nifErrMsg.value = "You must enter at least 4 characters in the NIF"
        }
        enableSignUpButton()
    }
    fun ValidateAccessType(){

        if (accessType.value.length >=4){
            isaccessTypeValid.value = true
            accessTypeErrMsg.value = ""
        }
        else{
            isaccessTypeValid.value = false
            accessTypeErrMsg.value = "You must enter at least 4 characters in the access type"
        }
        enableSignUpButton()
    }
    fun ValidateAddress(){

        if (address.value.length >=5){
            isaddressValid.value = true
            addressErrMsg.value = ""
        }
        else{
            isaddressValid.value = false
            addressErrMsg.value = "You must enter at least 5 characters in the addess"
        }
        enableSignUpButton()
    }
    fun ValidateGender(){

        if (gender.value.length >=1){
            isgenderValid.value = true
            genderErrMsg.value = ""
        }
        else{
            isgenderValid.value = false
            genderErrMsg.value = "You must enter at least 1 characters in the gender"
        }
        enableSignUpButton()
    }
    fun ValidateSchoolName(){

        if (schoolName.value.length >=3){
            isschoolNameValid.value = true
            schoolNameErrMsg.value = ""
        }
        else{
            isschoolNameValid.value = false
            schoolNameErrMsg.value = "You must enter at least 4 characters in the school name"
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

    private val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signuoFlow: StateFlow<Response<FirebaseUser>?> = _signupFlow

    var user = User()
    fun onSignUp(){
        user.name = name.value
        user.lastname = lastname.value
        user.nif = nif.value
        user.address = address.value
        user.birthday = birthday.value
        user.accesType = accessType.value
        user.gender = gender.value
        user.schoolName = schoolName.value
        user.email = email.value
        user.password = password.value
        user.username = "${name.value} ${lastname.value}"

        signup(user)
    }
    fun createUser() = viewModelScope.launch {
        user.id  = authUseCases.getCurrentUser()!!.uid
        usersUseCases.create(user)
    }
    fun signup(user: User) = viewModelScope.launch {
        _signupFlow.value = Response.Loading
        val result = authUseCases.signup(user)
        _signupFlow.value = result
    }
    fun enableSignUpButton(){
        isEnableSignupButton = isEmailValid.value == true &&
                isPasswordValid.value == true &&
                isconfirmPassword.value == true &&
                isnameValid.value == true &&
                islastnameValid.value == true &&
                isnifValid.value == true &&
                isaddressValid.value == true &&
                isaccessTypeValid.value == true &&
                isgenderValid.value == true &&
                isschoolNameValid.value == true
    }
}