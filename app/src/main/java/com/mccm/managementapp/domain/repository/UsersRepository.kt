package com.mccm.managementapp.domain.repository

import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun create(user: User):Response<Boolean>
    fun getUserById(id: String): Flow<User>
}