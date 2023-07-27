package com.mccm.managementapp.domain.use_cases.posts

import com.mccm.managementapp.domain.repository.AnnotationRepository
import javax.inject.Inject

class GetPost @Inject constructor(private val repository: AnnotationRepository) {
    operator fun invoke()= repository.getPost()
}