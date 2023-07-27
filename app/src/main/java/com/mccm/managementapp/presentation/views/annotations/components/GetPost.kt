package com.mccm.managementapp.presentation.views.annotations.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.presentation.components.ProgressBar
import com.mccm.managementapp.presentation.views.annotations.AnnotationsViewModel

@Composable
fun GetPost(viewModel: AnnotationsViewModel = hiltViewModel()) {
    when(val response = viewModel.postsResponse){
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            LaunchedEffect(Unit) {
            }
            AnnotationsContent(post = response.data)
        }
        is Response.Failure ->{
            Toast.makeText(
                LocalContext.current,
                response.exception?.message ?:"Error desconocido",
                Toast.LENGTH_LONG).show()
        }
        else -> {}
    }
}