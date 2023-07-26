package com.mccm.managementapp.presentation.views.animalscourses.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mccm.managementapp.presentation.components.DefaultHeaderContentView
import com.mccm.managementapp.presentation.views.animalscourses.AnimalsCoursesViewModel

@Composable
fun AnimalsCoursesContent(viewModel: AnimalsCoursesViewModel = hiltViewModel()) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState()))
    {
        Column {
            AnimalsCoursesHeader()
            DefaultHeaderContentView(text = "Animal course statistics")
            AnimalsCoursesBarraGraphic()
            AnimalsCoursesPastelGraphic()
            AnimalsCoursesLinearGraphic ()
        }
    }
}