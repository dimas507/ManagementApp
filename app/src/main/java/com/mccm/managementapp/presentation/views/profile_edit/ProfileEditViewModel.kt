package com.mccm.managementapp.presentation.views.profile_edit

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class ProfileEditViewModel @Inject constructor(
    private val usersUseCases: UsersUseCases,
    private val authUseCases: AuthUseCases,
) : ViewModel() {

    var schoolNameErrMsg by mutableStateOf("")
        private set
    //State Form
    var state by mutableStateOf(ProfileEditState())
        private set
    // User data
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user
    //Response
    var updateResponse
    by mutableStateOf<Response<Boolean>>(Response.Success(false))
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
    init {
        val currentUser = authUseCases.getCurrentUser()
        if (currentUser != null) {
            getUserById(currentUser.uid)
        }
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
    }
    fun onUpdate(){
        val currentUser = authUseCases.getCurrentUser()
        val myUser = User(
            id= currentUser!!.uid,
            schoolName = state.schoolName,
            address = state.address,
            nif = state.nif,
            image = ""
        )
        update(myUser)
    }
    fun update(user: User) = viewModelScope.launch {
        updateResponse = Response.Loading
        val result = usersUseCases.update(user)
        updateResponse = result
    }
    private fun getUserById(userId: String) = viewModelScope.launch {
        usersUseCases.getUserById(userId).collect { user ->
            _user.emit(user)
            state = state.copy(schoolName = user.schoolName)
            state = state.copy(nif = user.nif)
            state = state.copy(address = user.address)
        }
    }
    fun onSchoolNameInput(schoolName: String){
        state = state.copy(schoolName = schoolName)
    }
    fun ValidateSchoolName(){
        if (state.schoolName.length >=3){
            schoolNameErrMsg = ""
        }
        else{
            schoolNameErrMsg = "You must enter at least 4 characters in the school name"
        }
    }
    fun onNifInput(nif: String){
        state = state.copy(nif = nif)}
    fun onAddressInput(address: String){
        state = state.copy(address = address)
    }
    //image
    var imageUri by mutableStateOf<Uri?>(null)
    var hasImage by mutableStateOf(false)
    fun onResult(result: Boolean){
        hasImage = result
    }
    fun onGalleryResult(uri: Uri){
        hasImage = uri != null
        imageUri = uri
    }
}