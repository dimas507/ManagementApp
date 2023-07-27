package com.mccm.managementapp.presentation.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.presentation.views.profile_edit.ProfileEditViewModel


@Composable
fun SaveImage(viewModel: ProfileEditViewModel = hiltViewModel()) {
    when ( val response = viewModel.saveImageResponse){
        Response.Loading ->{
            ProgressBar()
        }
        is Response.Success -> {
            viewModel.onUpdate(response.data)
        }
        is Response.Failure ->{
            Toast.makeText(LocalContext.current,
                response.exception?.message ?: "Unknown Error SaveImage" ,
                Toast.LENGTH_SHORT).show()
        }

        else -> {}
    }
}