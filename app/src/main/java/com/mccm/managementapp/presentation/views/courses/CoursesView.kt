package com.mccm.managementapp.presentation.views.courses

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.mccm.managementapp.presentation.views.courses.components.CoursesContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesView() {
    Scaffold(
        topBar = {},
        content = { CoursesContent() },
        bottomBar = {}
    )
}