package com.mccm.managementapp.presentation.views.courses.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.components.DefaultInsideTopBar


@Composable
fun CoursesTopBar(navController: NavHostController) {
    DefaultInsideTopBar(navController, colorBackground = Color.White)
}