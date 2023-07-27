package com.mccm.managementapp.presentation.views.annotations.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mccm.managementapp.domain.model.Post

@Composable
fun AnnotationsContent(post: List<Post>) {
    LazyColumn(
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()){
        items(
            items = post
        ){
            post ->
            AnnotationCard(post = post)
        }
    }
}