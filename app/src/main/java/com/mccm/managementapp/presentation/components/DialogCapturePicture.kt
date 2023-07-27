package com.mccm.managementapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mccm.managementapp.presentation.ui.theme.LightBlue200
import com.mccm.managementapp.presentation.ui.theme.Orange200


@Composable
fun DialogCapturePicture(
    status: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit
    ){
    if (status.value){
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            onDismissRequest = { status.value = false },
            containerColor = Color.White,
            confirmButton = {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(Orange200),
                        modifier = Modifier.width(130.dp),
                        onClick = {
                            status.value = false
                            pickImage() }) {
                        Text(text = "Gallery",
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.padding(15.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(LightBlue200),
                        modifier = Modifier.width(130.dp),
                        onClick = {
                            status.value = false
                            takePhoto() }) {
                        Text(text = "Camera",
                            color = Color.White
                        )
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun PreviewDialogCapturePicture() {
    val status = remember { mutableStateOf(true) }
    DialogCapturePicture(
        status = status,
        takePhoto = { /* Aquí puedes poner código de ejemplo para tomar una foto */ },
        pickImage = { /* Aquí puedes poner código de ejemplo para seleccionar una imagen */ }
    )
}
