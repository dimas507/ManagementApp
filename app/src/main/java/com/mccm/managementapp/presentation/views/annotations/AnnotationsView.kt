package com.mccm.managementapp.presentation.views.annotations

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.ui.theme.Indigo900
import com.mccm.managementapp.presentation.views.annotations.components.GetPost
import com.mccm.managementapp.presentation.views.courses.components.CoursesTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnnotationsView(navController: NavHostController,
                    viewModel: AnnotationsViewModel = hiltViewModel() ) {
    Scaffold(
        topBar = { CoursesTopBar(navController) },
        content = { GetPost() },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 50.dp),
                containerColor = Indigo900,
                onClick = { navController.navigate(AppScreen.NewPostView.route) })
            {
                Icon(imageVector = Icons.Default.Add,
                    tint = Color.White,
                    contentDescription = "")
            }
        }
    )
}