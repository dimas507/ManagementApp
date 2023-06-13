package com.mccm.managementapp.domain.use_cases.users

import com.mccm.managementapp.domain.model.User
import com.mccm.managementapp.domain.repository.UsersRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: UsersRepository ) {
    suspend operator fun invoke(user:User) = repository.create(user)
}