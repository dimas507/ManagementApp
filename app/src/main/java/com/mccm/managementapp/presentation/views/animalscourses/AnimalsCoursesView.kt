package com.mccm.managementapp.presentation.views.animalscourses

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.views.animalscourses.components.AnimalsCoursesContent
import com.mccm.managementapp.presentation.views.animalscourses.components.AnimalsCoursesTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalsCoursesView(navController: NavHostController) {
    Scaffold(
        topBar = { AnimalsCoursesTopBar(navController) },
        content = { AnimalsCoursesContent() },
        bottomBar = {  }
    )
}