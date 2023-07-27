package com.mccm.managementapp.domain.repository

import com.mccm.managementapp.domain.model.Post
import com.mccm.managementapp.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface AnnotationRepository {
    suspend fun create(post: Post, file: File): Response<Boolean>
    fun getPost(): Flow<Response<List<Post>>>
}