package com.mccm.managementapp.presentation.views.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(): ViewModel() {
    //State Form
    var state by mutableStateOf(ProfileEditState())
        private set

    fun onNameInput(name: String){
        state = state.copy(name = name)
    }
    fun onLastnameInput(lastname: String){
        state = state.copy(lastname = lastname)
    }
    fun onNifInput(nif: String){
        state = state.copy(nif = nif)
    }
    fun onAddressInput(address: String){
        state = state.copy(address = address)
    }
    fun onBirthdayInput(birthday: String){
        state = state.copy(birthday = birthday)
    }
    fun onSchoolNameInput(schoolName: String){
        state = state.copy(schoolName = schoolName)
    }

    var nameErrMsg by mutableStateOf("")
        private set

    var lastnameErrMsg by mutableStateOf("")
        private set

    var nifErrMsg by mutableStateOf("")
        private set

    var addressErrMsg by mutableStateOf("")
        private set

    var schoolNameErrMsg by mutableStateOf("")
        private set

    fun ValidateName(){

        if (state.name.length >=3){
            nameErrMsg = ""
        }
        else{
            nameErrMsg = "You must enter at least 3 characters in the name and only use letters"
        }
    }
    fun ValidateLastname(){

        if (state.lastname.length >=3){
            lastnameErrMsg = ""
        }
        else{
            lastnameErrMsg = "You must enter at least 3 characters in the lastname and only use letters"
        }
    }
    fun ValidateNIF(){

        if (state.nif.length >=4){
            nifErrMsg = ""
        }
        else{
            nifErrMsg = "You must enter at least 4 characters in the NIF"
        }
    }
    fun ValidateAddress(){

        if (state.address.length >=5){
            addressErrMsg = ""
        }
        else{
            addressErrMsg = "You must enter at least 5 characters in the addess"
        }
    }
    fun ValidateSchoolName(){

        if (state.schoolName.length >=3){
            schoolNameErrMsg = ""
        }
        else{
            schoolNameErrMsg = "You must enter at least 4 characters in the school name"
        }
    }
}