package com.mccm.managementapp.presentation.views.signup

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mccm.managementapp.presentation.components.DefaultTopBar
import com.mccm.managementapp.presentation.ui.theme.Orange2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpView(navController: NavHostController){
    Scaffold(
        topBar = {
                 DefaultTopBar(
                     title = "New User",
                     upAvailable = true,
                     navController = navController,
                     color = Orange2
                 )
        },
        content = {
                  SignupContent(navController)
        },
        bottomBar = {}
    )
}