package com.mccm.managementapp.presentation.views.welcome


import androidx.lifecycle.ViewModel
import com.mccm.managementapp.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(private val authUseCases: AuthUseCases)  : ViewModel() {
    fun logout(){
        authUseCases.logout()
    }
}