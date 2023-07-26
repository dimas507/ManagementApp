package com.mccm.managementapp.presentation.views.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    //State Form
    var state by mutableStateOf(ProfileEditState())
        private set

    // User data
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    init {
        val currentUser = authUseCases.getCurrentUser()
        if (currentUser != null) {
            getUserById(currentUser.uid)
        }
    }
    private fun getUserById(userId: String) = viewModelScope.launch {
        usersUseCases.getUserById(userId).collect { user ->
            _user.emit(user)
            state = state.copy(schoolName = user.schoolName)
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