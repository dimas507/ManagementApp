package com.mccm.managementapp.presentation.views.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.components.DefaultInsideTopBar

@Composable
fun ProfileTopBar(navController: NavHostController) {
    DefaultInsideTopBar(navController, tint = Color.White)
}