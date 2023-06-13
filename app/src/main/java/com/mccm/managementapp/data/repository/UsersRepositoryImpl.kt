package com.mccm.managementapp.data.repository

import com.google.firebase.firestore.CollectionReference
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.domain.model.User
import com.mccm.managementapp.domain.repository.UsersRepository
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val usersRef: CollectionReference):UsersRepository {
    override suspend fun create(user: User): Response<Boolean> {
        return try {
            user.password = ""
            usersRef.document(user.id).set(user).await()
            Response.Success(true)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}