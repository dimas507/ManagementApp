package com.mccm.managementapp.presentation.views.profile_edit.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.presentation.components.ProgressBar
import com.mccm.managementapp.presentation.views.profile_edit.ProfileEditViewModel


@Composable
fun Update(viewModel: ProfileEditViewModel = hiltViewModel()){
    when (val updateResponse = viewModel.updateResponse){
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            Toast.makeText(LocalContext.current,"Update data",
                Toast.LENGTH_LONG).show()
        }
        is Response.Failure ->{
            Toast.makeText(LocalContext.current,
                updateResponse.exception?.message?: "Unknown error in update",
                Toast.LENGTH_LONG).show()
        }

        else -> {}
    }
}