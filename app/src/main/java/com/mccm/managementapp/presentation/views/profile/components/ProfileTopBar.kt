package com.mccm.managementapp.presentation.views.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.components.DefaultInsideTopBar
import com.mccm.managementapp.presentation.components.DefaultTopBar
import com.mccm.managementapp.presentation.ui.theme.Indigo700
import com.mccm.managementapp.presentation.ui.theme.Indigo900

@Composable
fun ProfileTopBar(navController: NavHostController) {
    DefaultInsideTopBar(navController, colorBackground = Color.White)
}