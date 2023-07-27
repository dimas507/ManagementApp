package com.mccm.managementapp.presentation.navigation


sealed class AppScreen (val route: String){

    object Login: AppScreen("login")
    object Signup: AppScreen("signup")
    object Welcome: AppScreen("welcome")
    object Profile:AppScreen("perfil")
    object Courses:AppScreen("courses")
    object ProfileEdit: AppScreen("profile/edit/{userId}"){
        fun passUser(userId: String) = "profile/edit/${userId}"

    }
    object AnimalsCourses: AppScreen("animalscourses")
    object Annotations: AppScreen("annotations")
    object NewPostView: AppScreen("newannotations")
}
