package com.mccm.managementapp.presentation.views.profile_edit.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.components.DefaultOutlinedTextField
import com.mccm.managementapp.presentation.ui.theme.Blue900
import com.mccm.managementapp.presentation.ui.theme.Orange2
import com.mccm.managementapp.presentation.ui.theme.Orange400
import com.mccm.managementapp.presentation.ui.theme.White
import com.mccm.managementapp.presentation.views.profile_edit.ProfileEditViewModel
import com.mccm.managementapp.presentation.views.signup.SignUpViewModel

@Composable
fun ProfileEditContent(navController: NavHostController) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState()))
    {
        BoxHeader()
        CardForm()
    }

}
@Composable
fun BoxHeader(){
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
            Image(
                modifier = Modifier
                    .height(160.dp),
                painter = painterResource(id = R.drawable.editperson),
                contentDescription = "teacher learning")
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
                value = state.name,
                onValueChange = { viewModel.onNameInput(it) },
                label = "Name",
                icon = Icons.Default.Person,
                validateField = {viewModel.ValidateName()},
                errorMsg = viewModel.nameErrMsg
            )
            DefaultOutlinedTextField(
                modifier = Modifier.padding(start = 30.dp, top = 10.dp),
                value = state.lastname,
                onValueChange = { viewModel.onLastnameInput(it) },
                label = "Lastname",
                icon = Icons.Outlined.Person,
                validateField = {viewModel.ValidateLastname()},
                errorMsg = viewModel.lastnameErrMsg
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
                value = state.birthday,
                onValueChange = { viewModel.onBirthdayInput(it)},
                label = "Birthday",
                painter = painterResource(id = R.drawable.calendar_month)
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
                onClick = {},
                color = Orange400
            )
        }
    }
}