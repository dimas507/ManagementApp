package com.mccm.managementapp.presentation.views.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
class SignUpViewModel @Inject constructor(private val authUseCases: AuthUseCases,
                                          private val usersUseCases: UsersUseCases)
    :ViewModel() {
    //State Form
    var state by mutableStateOf(SignupState())
        private set

    //Username
    var isnameValid by mutableStateOf(false)
        private set
    var nameErrMsg by mutableStateOf("")
        private set

    var islastnameValid by mutableStateOf(false)
        private set
    var lastnameErrMsg by mutableStateOf("")
        private set

    //Confirm Password
    var isconfirmPassword by mutableStateOf(false)
        private set
    var confirmPasswordErrMsg by mutableStateOf("")
        private set

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

    //NIF
    var isnifValid by mutableStateOf(false)
        private set
    var nifErrMsg by mutableStateOf("")
        private set

    //Address
    var isaddressValid by mutableStateOf(false)
        private set
    var addressErrMsg by mutableStateOf("")
        private set

    //Birthday

    //Access type
    var isaccessTypeValid by mutableStateOf(false)
        private set
    var accessTypeErrMsg by mutableStateOf("")
        private set

    //Gender
    var isgenderValid by mutableStateOf(false)
        private set
    var genderErrMsg by mutableStateOf("")
        private set

    //School name
    var isschoolNameValid by mutableStateOf(false)
        private set
    var schoolNameErrMsg by mutableStateOf("")
        private set

    //Button
    var isEnableSignupButton = false

    //functions
    fun isValidString(input: String): Boolean {
        val pattern = Regex("^[a-zA-Z ]+$")
        return pattern.matches(input)
    }

    fun ValidateName(){

        if (state.name.length >=3 && isValidString(state.name)){
            isnameValid = true
            nameErrMsg = ""
        }
        else{
            isnameValid = false
            nameErrMsg = "You must enter at least 3 characters in the name and only use letters"
        }
        enableSignUpButton()
    }
    fun ValidateLastname(){

        if (state.lastname.length >=3 && isValidString(state.lastname)){
            islastnameValid = true
            lastnameErrMsg = ""
        }
        else{
            islastnameValid = false
            lastnameErrMsg = "You must enter at least 3 characters in the lastname and only use letters"
        }
        enableSignUpButton()
    }

    fun ValidateNIF(){

        if (state.nif.length >=4){
            isnifValid = true
            nifErrMsg = ""
        }
        else{
            isnifValid = false
            nifErrMsg = "You must enter at least 4 characters in the NIF"
        }
        enableSignUpButton()
    }
    fun ValidateAccessType(){

        if (state.accessType.length >=4){
            isaccessTypeValid = true
            accessTypeErrMsg = ""
        }
        else{
            isaccessTypeValid = false
            accessTypeErrMsg = "You must enter at least 4 characters in the access type"
        }
        enableSignUpButton()
    }
    fun ValidateAddress(){

        if (state.address.length >=5){
            isaddressValid = true
            addressErrMsg = ""
        }
        else{
            isaddressValid = false
            addressErrMsg = "You must enter at least 5 characters in the addess"
        }
        enableSignUpButton()
    }
    fun ValidateGender(){

        if (state.gender.length >=1){
            isgenderValid = true
            genderErrMsg = ""
        }
        else{
            isgenderValid = false
            genderErrMsg = "You must enter at least 1 characters in the gender"
        }
        enableSignUpButton()
    }
    fun ValidateSchoolName(){

        if (state.schoolName.length >=3){
            isschoolNameValid = true
            schoolNameErrMsg = ""
        }
        else{
            isschoolNameValid = false
            schoolNameErrMsg = "You must enter at least 4 characters in the school name"
        }
        enableSignUpButton()
    }
    fun validateEmail(){
        if(Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            isEmailValid = true
            emailErrMsg = ""
        }
        else {
            isEmailValid = false
            emailErrMsg = "Email not valid "
        }
        enableSignUpButton()
    }

    fun validatePassword(){
        if(state.password.length >= 6){
            isPasswordValid = true
            passwordlErrMsg = ""
        }
        else {
            passwordlErrMsg = "You must enter at least 6 characters"

        }
        enableSignUpButton()
    }

    fun ValidateConfirmPassword(){
        if (state.password == state.confirmPassword){
            isconfirmPassword = true
            confirmPasswordErrMsg = ""
        }
        else{
            isconfirmPassword = false
            confirmPasswordErrMsg = "Passwords don't match"
        }
        enableSignUpButton()
    }

    var signUpResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    var user = User()

    fun onNameInput(name: String){
        state = state.copy(name = name)
    }
    fun onLastnameInput(lastname: String){
        state = state.copy(lastname = lastname)
    }
    fun onNifInput(nif: String){
        state = state.copy(nif = nif)
    }fun onAddressInput(address: String){
        state = state.copy(address = address)
    }
    fun onBirthdayInput(birthday: String){
        state = state.copy(birthday = birthday)
    }
    fun onAccesTypeInput(accesType: String){
        state = state.copy(accessType = accesType)
    }
    fun onGenderInput(gender: String){
        state = state.copy(gender = gender)
    }
    fun onSchoolNameInput(schoolName: String){
        state = state.copy(schoolName = schoolName)
    }
    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }
    fun onConfirmPasswordInput(confirmPassword: String){
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun onSignUp(){
        user.name = state.name
        user.lastname = state.lastname
        user.nif = state.nif
        user.address = state.address
        user.birthday = state.birthday
        user.accesType = state.accessType
        user.gender = state.gender
        user.schoolName = state.schoolName
        user.email = state.email
        user.password = state.password
        user.username = "${state.name} ${state.lastname}"

        signup(user)
    }
    fun createUser() = viewModelScope.launch {
        user.id  = authUseCases.getCurrentUser()!!.uid
        usersUseCases.create(user)
    }
    fun signup(user: User) = viewModelScope.launch {
        signUpResponse = Response.Loading
        val result = authUseCases.signup(user)
        signUpResponse = result
    }
    fun enableSignUpButton(){
        isEnableSignupButton = isEmailValid == true &&
                isPasswordValid == true &&
                isconfirmPassword == true &&
                isnameValid == true &&
                islastnameValid == true &&
                isnifValid == true &&
                isaddressValid == true &&
                isaccessTypeValid == true &&
                isgenderValid == true &&
                isschoolNameValid == true
    }
}