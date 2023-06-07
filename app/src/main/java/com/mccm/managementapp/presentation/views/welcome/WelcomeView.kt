package com.mccm.managementapp.presentation.views.welcome

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.views.signup.SignUpView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeView(navController: NavHostController, viewModel: WelcomeViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {},
        content = { DefaultButton(
            text = "Logout",
            onClick = { viewModel.logout()
                      navController.navigate(route = AppScreen.Login.route){
                          popUpTo(AppScreen.Welcome.route){inclusive = true}
                      }
                      },
            modifier = Modifier) },
        bottomBar = {  }
    )
}

@Preview
@Composable
fun PreviewWelcomepView() {
    WelcomeView(rememberNavController())
}