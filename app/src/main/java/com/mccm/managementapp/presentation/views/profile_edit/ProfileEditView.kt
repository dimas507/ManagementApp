package com.mccm.managementapp.presentation.views.profile_edit

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mccm.managementapp.presentation.components.DefaultTopBar
import com.mccm.managementapp.presentation.ui.theme.Orange2
import com.mccm.managementapp.presentation.views.profile_edit.components.ProfileEditContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditView(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Edit User",
                upAvailable = true,
                navController = navController,
                color = Orange2
            )
        },
        content = {
            ProfileEditContent(navController)
        },
        bottomBar = {}
    )
}