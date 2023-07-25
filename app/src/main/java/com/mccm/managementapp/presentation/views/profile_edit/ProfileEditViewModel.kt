package com.mccm.managementapp.presentation.views.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mccm.managementapp.domain.use_cases.auth.AuthUseCases
import com.mccm.managementapp.domain.use_cases.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    private val usersUseCases: UsersUseCases,
    private val authUseCases: AuthUseCases,): ViewModel() {
    //State Form
    var state by mutableStateOf(ProfileEditState())
        private set

    val currentUser = authUseCases.getCurrentUser()
    init {
        getUserById(state.schoolName)
    }
    private fun getUserById(schoolName: String) = viewModelScope.launch {
        usersUseCases.getUserById(currentUser!!.uid).collect(){
            state = state.copy(schoolName = schoolName)
        }
    }
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