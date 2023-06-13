package com.mccm.managementapp.presentation.views.welcome.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.ui.theme.Indigo900
import com.mccm.managementapp.presentation.views.welcome.WelcomeViewModel

@Composable
fun  WelcomeTopBar(navController: NavHostController, viewModel: WelcomeViewModel = hiltViewModel()) {
    Column(modifier = Modifier.background(Indigo900).fillMaxWidth()) {
        DefaultButton(
            text = "Perfil",
            onClick = {navController.navigate(route = AppScreen.Profile.route)
            },
            modifier = Modifier
        )
    }
}