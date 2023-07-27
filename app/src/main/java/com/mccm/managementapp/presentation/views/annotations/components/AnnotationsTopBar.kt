package com.mccm.managementapp.presentation.views.annotations.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.components.DefaultInsideTopBar

@Composable
fun AnnotationsTopBar(navController: NavHostController){
    DefaultInsideTopBar(navController, colorBackground = Color.White)
}