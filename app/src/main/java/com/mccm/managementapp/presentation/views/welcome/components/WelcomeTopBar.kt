package com.mccm.managementapp.presentation.views.welcome.components


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.components.DefaultInsideTopBar
import com.mccm.managementapp.presentation.views.welcome.WelcomeViewModel

@Composable
fun  WelcomeTopBar(navController: NavHostController,) {
    DefaultInsideTopBar(navController, colorBackground = Color.White)
}