package com.mccm.managementapp.presentation.new_annotations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.components.DefaultOutlinedTextField
import com.mccm.managementapp.presentation.components.DialogCapturePicture
import com.mccm.managementapp.presentation.new_annotations.NewAnnotationViewModel
import com.mccm.managementapp.presentation.ui.theme.BlueTop

@Composable
fun NewAnnotationContent(
    viewModel: NewAnnotationViewModel = hiltViewModel()
) {
    viewModel.resultingActivityHandler.handle()
    val state = viewModel.state
    var dialogState = remember { mutableStateOf(false) }
    DialogCapturePicture(
        status = dialogState,
        takePhoto = {viewModel.takePhoto()},
        pickImage = {viewModel.pickImage()}
    )
    Column(modifier = Modifier
        .verticalScroll(
            rememberScrollState()
        )
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp)
                    .height(250.dp)
                    .background(BlueTop)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (viewModel.state.image != ""){
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            model = viewModel.state.image,
                            contentDescription = "Selected image",
                            contentScale = ContentScale.Crop
                        )
                    }
                    else{
                        Image(
                            modifier = Modifier
                                .size(120.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            painter = painterResource(id = R.drawable.add_image),
                            contentDescription = ""
                        )
                        Text(
                            modifier = Modifier.padding(12.dp),
                            text = "Select an image",
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        DefaultOutlinedTextField(
            modifier = Modifier.padding(top = 25.dp),
            value = state.name,
            onValueChange = { viewModel.onNameInput(it) },
            label = "Name of the annotation",
            icon = Icons.Default.Create)
        DefaultOutlinedTextField(
            modifier = Modifier.padding(top = 10.dp),
            value = state.description,
            onValueChange = { viewModel.onDescriptionInput(it) },
            label = "Description",
            icon = Icons.Default.List,)
        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            color = Color.Black,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            text = "Category")
        viewModel.radioOptions.forEach{
            option ->
            Row(modifier = Modifier
                .padding(horizontal = 35.dp)
                .fillMaxWidth()
                .selectable(selected = (option.category == state.category),
                    onClick = {
                        viewModel.onCategoryInput(option.category)
                    })) {
                RadioButton(
                    selected = (option.category == state.category),
                    onClick = {
                        viewModel.onCategoryInput(option.category)
                    })
                Row() {
                    Text(
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(10.dp)
                            .width(200.dp),
                        text = option.category)
                    Image(
                        modifier = Modifier.height(40.dp),
                        painter = painterResource(id = option.image),
                        contentDescription = "")
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 25.dp))
        DefaultButton(text = "Publish",
            onClick = { viewModel.onNewAnnotation() },
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxWidth())
        Spacer(modifier = Modifier.padding(bottom = 25.dp))
    }
}