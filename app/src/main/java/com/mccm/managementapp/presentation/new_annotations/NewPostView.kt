package com.mccm.managementapp.presentation.new_annotations

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.components.DefaultTopBar
import com.mccm.managementapp.presentation.new_annotations.components.AddAnnotation
import com.mccm.managementapp.presentation.new_annotations.components.NewAnnotationContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPostView (navController: NavHostController){
    Scaffold(
        topBar = { DefaultTopBar(title = "New Annotation",
            upAvailable = true,
            navController = navController) },
        content = { NewAnnotationContent()  },
        bottomBar = {}
    )
    AddAnnotation()
}