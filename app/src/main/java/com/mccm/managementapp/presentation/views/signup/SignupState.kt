package com.mccm.managementapp.presentation.views.signup

data class SignupState(
    val name: String = "",
    val lastname: String = "",
    val confirmPassword: String = "",
    val email: String = "",
    val password: String = "",
    val nif: String = "",
    val address: String = "",
    val birthday: String = "",
    val accessType: String = "",
    val gender: String = "",
    val schoolName: String = "",
)
