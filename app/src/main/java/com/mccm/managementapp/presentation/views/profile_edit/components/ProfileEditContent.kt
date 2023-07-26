package com.mccm.managementapp.presentation.views.profile_edit.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.components.DefaultOutlinedTextField
import com.mccm.managementapp.presentation.ui.theme.Blue900
import com.mccm.managementapp.presentation.ui.theme.Orange2
import com.mccm.managementapp.presentation.ui.theme.Orange400
import com.mccm.managementapp.presentation.ui.theme.White
import com.mccm.managementapp.presentation.utils.ComposeFileProvider
import com.mccm.managementapp.presentation.views.profile.ProfileViewModel
import com.mccm.managementapp.presentation.views.profile_edit.ProfileEditViewModel

@Composable
fun ProfileEditContent(navController: NavHostController,
                       viewModel: ProfileViewModel = hiltViewModel()) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState()))
    {
        BoxHeader()
        CardForm()
    }

}
@Composable
fun BoxHeader(viewModel: ProfileEditViewModel = hiltViewModel()){
    val context = LocalContext.current
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {uri ->
            uri?.let { viewModel.onGalleryResult(it) }
        })

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = {hasImage ->
            viewModel.onResult(hasImage)
        })
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Orange2)
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.height(68.dp))
            if (viewModel.hasImage && viewModel.imageUri != null){
                AsyncImage(
                    modifier = Modifier
                        .height(100.dp)
                        .clip(CircleShape),
                    model = viewModel.imageUri
                    , contentDescription = "Selected image")
            }
            else{
                Image(
                    modifier = Modifier
                        .size(125.dp)
                        .clickable {
                            //imagePicker.launch("image/*")
                            val uri = ComposeFileProvider.getImageUri(context)
                            viewModel.imageUri = uri
                            cameraLauncher.launch(uri)
                        },
                    painter = painterResource(id = R.drawable.user_1),
                    contentDescription = ""
                )
            }
        }
    }
}

@Composable
fun CardForm(viewModel: ProfileEditViewModel = hiltViewModel()){
    val state = viewModel.state

    Card(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 250.dp)
            .absolutePadding(10.dp),
        border = BorderStroke(3.dp, Color.White)
    ) {
        Column(
            modifier = Modifier
                .background(color = White)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                text = "Update",
                color = Blue900,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            DefaultOutlinedTextField(
                modifier = Modifier.padding(start = 30.dp, top = 10.dp),
                value = state.nif,
                onValueChange = { viewModel.onNifInput(it) },
                label = "NIF",
                painter = painterResource(id = R.drawable.pin),
                validateField = {viewModel.ValidateNIF()},
                errorMsg = viewModel.nifErrMsg
            )
            DefaultOutlinedTextField(
                modifier = Modifier.padding(start = 30.dp, top = 10.dp),
                value = state.address,
                onValueChange = { viewModel.onAddressInput(it)},
                label = "Address",
                painter = painterResource(id = R.drawable.my_location),
                validateField = {viewModel.ValidateAddress()},
                errorMsg = viewModel.addressErrMsg
            )
            DefaultOutlinedTextField(
                modifier = Modifier.padding(start = 30.dp, top = 10.dp),
                value = state.schoolName,
                onValueChange = { viewModel.onSchoolNameInput(it) },
                label = "School name",
                painter = painterResource(id = R.drawable.house),
                validateField = {viewModel.ValidateSchoolName()},
                errorMsg = viewModel.schoolNameErrMsg
            )
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(35.dp),
                text = "Update",
                onClick = {viewModel.onUpdate()},
                color = Orange400
            )
        }
    }
}