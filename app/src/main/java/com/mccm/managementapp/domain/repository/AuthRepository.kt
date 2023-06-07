package com.mccm.managementapp.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.domain.model.User


interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Response<FirebaseUser>
    suspend fun signup(user: User): Response<FirebaseUser>
    fun logout()
}