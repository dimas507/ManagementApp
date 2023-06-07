package com.mccm.managementapp.domain.use_cases.auth

import com.mccm.managementapp.domain.repository.AuthRepository
import javax.inject.Inject

class Logout @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.logout()
}