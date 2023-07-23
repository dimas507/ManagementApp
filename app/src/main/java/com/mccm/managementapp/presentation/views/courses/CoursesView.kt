package com.mccm.managementapp.presentation.views.courses

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.views.courses.components.CoursesBottonBar
import com.mccm.managementapp.presentation.views.courses.components.CoursesContent
import com.mccm.managementapp.presentation.views.courses.components.CoursesTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesView(navController: NavHostController) {
    Scaffold(
        topBar = {CoursesTopBar(navController)},
        content = {CoursesContent(navController)},
        bottomBar = { CoursesBottonBar(navController)}
    )
}