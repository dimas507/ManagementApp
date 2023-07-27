package com.mccm.managementapp.presentation.new_annotations.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.presentation.components.ProgressBar
import com.mccm.managementapp.presentation.new_annotations.NewAnnotationViewModel

@Composable
fun AddAnnotation(viewModel: NewAnnotationViewModel = hiltViewModel()){
    when(val response = viewModel.createPostResponse){
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            Toast.makeText(
                LocalContext.current,"Annotation successfully created ",
                Toast.LENGTH_SHORT).show()
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