package com.mccm.managementapp.presentation.views.login

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.views.login.components.Login
import com.mccm.managementapp.presentation.views.login.components.LoginBottonBar
import com.mccm.managementapp.presentation.views.login.components.LoginContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(navController: NavHostController) {

    Scaffold(
        topBar = {},
        content = { LoginContent(navController) },
        bottomBar = { LoginBottonBar(navController) }
    )
    //Manage the status of login request
    Login(navController = navController)
}

