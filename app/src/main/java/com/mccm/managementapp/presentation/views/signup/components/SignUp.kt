package com.mccm.managementapp.presentation.views.signup.components


import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.views.signup.SignUpViewModel

@Composable
fun SignUP(navController:NavHostController, viewModel: SignUpViewModel = hiltViewModel() ){
        when(val signUpResponse = viewModel.signUpResponse) {
            Response.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }
            is Response.Success -> {
                LaunchedEffect(Unit){
                    viewModel.createUser()
                    navController.popBackStack(AppScreen.Login.route, true)
                    navController.navigate(route = AppScreen.Welcome.route)
                }
            }
            is Response.Failure ->{
                Toast.makeText(LocalContext.current, signUpResponse.exception?.message ?: "unknown error Registe" , Toast.LENGTH_LONG).show()
            }
            else -> {}
        }
}