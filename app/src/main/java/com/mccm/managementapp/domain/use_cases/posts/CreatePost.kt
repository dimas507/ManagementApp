package com.mccm.managementapp.domain.use_cases.posts

import com.mccm.managementapp.domain.model.Post
import com.mccm.managementapp.domain.repository.AnnotationRepository
import java.io.File
import javax.inject.Inject

class CreatePost @Inject constructor(private val repository: AnnotationRepository) {
    suspend operator fun invoke(post: Post, file: File) = repository.create(post, file)
}