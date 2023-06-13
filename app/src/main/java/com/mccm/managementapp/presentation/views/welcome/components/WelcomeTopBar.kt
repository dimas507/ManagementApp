package com.mccm.managementapp.presentation.views.welcome.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.views.welcome.WelcomeViewModel

@Composable
fun  WelcomeTopBar(navController: NavHostController, viewModel: WelcomeViewModel = hiltViewModel()) {
    DefaultButton(
        text = "Perfil",
        onClick = {navController.navigate(route = AppScreen.Profile.route)
        },
        modifier = Modifier
    )
}