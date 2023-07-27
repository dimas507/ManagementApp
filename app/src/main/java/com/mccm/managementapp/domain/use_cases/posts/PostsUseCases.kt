package com.mccm.managementapp.domain.use_cases.posts

data class PostsUseCases(
    val create: CreatePost,
    val getPost: GetPost
    )