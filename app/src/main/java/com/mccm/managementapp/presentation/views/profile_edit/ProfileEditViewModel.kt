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

    fun onSchoolNameInput(schoolName: String){
        state = state.copy(schoolName = schoolName)
    }

    var schoolNameErrMsg by mutableStateOf("")
        private set

    fun ValidateSchoolName(){

        if (state.schoolName.length >=3){
            schoolNameErrMsg = ""
        }
        else{
            schoolNameErrMsg = "You must enter at least 4 characters in the school name"
        }
    }
}