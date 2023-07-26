package com.mccm.managementapp.domain.use_cases.users

import com.mccm.managementapp.domain.model.User
import com.mccm.managementapp.domain.repository.UsersRepository
import javax.inject.Inject

class Update @Inject constructor(private val repository: UsersRepository) {
    suspend operator fun invoke(user: User) = repository.update(user)
}