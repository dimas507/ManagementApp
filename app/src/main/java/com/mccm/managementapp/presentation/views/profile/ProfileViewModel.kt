package com.mccm.managementapp.presentation.views.profile

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mccm.managementapp.domain.model.User
import com.mccm.managementapp.domain.use_cases.auth.AuthUseCases
import com.mccm.managementapp.domain.use_cases.users.UsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCases: AuthUseCases,
                                           private val usersUseCases: UsersUseCases
                                           ): ViewModel() {

    var userData by mutableStateOf(User())
        private set
    val currentUser = authUseCases.getCurrentUser()
    init {
        getUserById()
    }
    private fun getUserById() = viewModelScope.launch {
        usersUseCases.getUserById(currentUser!!.uid).collect(){
            userData = it
        }
    }
    fun logout(){
        authUseCases.logout()
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