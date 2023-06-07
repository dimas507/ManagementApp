package com.mccm.managementapp.domain.use_cases.auth

import com.mccm.managementapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.currentUser
}