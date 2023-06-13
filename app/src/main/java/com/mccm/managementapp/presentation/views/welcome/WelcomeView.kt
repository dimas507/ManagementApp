package com.mccm.managementapp.presentation.views.welcome

import WelcomeContent
import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.views.welcome.components.WelcomeBottonBar
import com.mccm.managementapp.presentation.views.welcome.components.WelcomeTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeView(navController: NavHostController, viewModel: WelcomeViewModel = hiltViewModel()) {

    Scaffold(
        topBar = { WelcomeTopBar(navController) },
        content = {WelcomeContent()},
        bottomBar = { }
    )
}

@Preview
@Composable
fun PreviewWelcomepView() {
    WelcomeView(rememberNavController())
}