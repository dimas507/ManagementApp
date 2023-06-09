package com.mccm.managementapp.domain.use_cases.auth

import com.mccm.managementapp.domain.model.User
import com.mccm.managementapp.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke (user: User) = repository.signup(user)
}