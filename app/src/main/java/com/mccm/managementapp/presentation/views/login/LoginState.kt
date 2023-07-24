package com.mccm.managementapp.presentation.views.login

import android.provider.ContactsContract.CommonDataKinds.Email

data class LoginState(
    val email: String = "",
    val password:String = ""
)
