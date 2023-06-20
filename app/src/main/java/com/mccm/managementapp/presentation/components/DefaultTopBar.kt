package com.mccm.managementapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.ui.theme.LightBlue900
import com.mccm.managementapp.presentation.ui.theme.ManagementAppTheme
import com.mccm.managementapp.presentation.views.courses.components.CoursesContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean= false,
    navController: NavHostController ?= null,
    color: Color = LightBlue900 ) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 19.sp,
                color = Color.White
            )
        },
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = { navController?.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White,
                    )
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = color)
    )
}
