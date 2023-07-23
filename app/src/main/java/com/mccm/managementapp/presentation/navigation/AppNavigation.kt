package com.mccm.managementapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mccm.managementapp.presentation.views.courses.CoursesView
import com.mccm.managementapp.presentation.views.login.LoginView
import com.mccm.managementapp.presentation.views.profile.ProfileView
import com.mccm.managementapp.presentation.views.profile_edit.ProfileEditView
import com.mccm.managementapp.presentation.views.signup.SignUpView
import com.mccm.managementapp.presentation.views.welcome.WelcomeView

@Composable
fun AppNavigation(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route){

        composable(route= AppScreen.Login.route){
            LoginView(navController)
        }

        composable(route = AppScreen.Signup.route){
            SignUpView(navController)
        }

        composable(route = AppScreen.Welcome.route){
            WelcomeView(navController)
        }

        composable(route = AppScreen.Profile.route){
            ProfileView(navController)
        }

        composable(route = AppScreen.Courses.route){
            CoursesView(navController)
        }

        composable(route = AppScreen.ProfileEdit.route){
            ProfileEditView(navController)
        }
    }
}