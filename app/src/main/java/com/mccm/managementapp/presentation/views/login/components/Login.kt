package com.mccm.managementapp.presentation.views.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.presentation.components.ProgressBar
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.views.login.LoginViewModel

@Composable
fun Login(navController:NavHostController, viewModel: LoginViewModel = hiltViewModel()){
    when(val loginResponse = viewModel.loginResponse){
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            LaunchedEffect(Unit) {
                navController.popBackStack(AppScreen.Login.route, true)
                navController.navigate(route = AppScreen.Welcome.route)
            }
            Toast.makeText(
                LocalContext.current,
                "Loggin",
                Toast.LENGTH_LONG).show()
        }
        is Response.Failure ->{
            Toast.makeText(
                LocalContext.current,
                loginResponse.exception?.message ?:"Error desconocido",
                Toast.LENGTH_LONG).show()
        }

        else -> {}
    }
}