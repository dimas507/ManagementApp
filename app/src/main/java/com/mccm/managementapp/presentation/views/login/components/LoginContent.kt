package com.mccm.managementapp.presentation.views.login.components


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.R
import com.mccm.managementapp.domain.model.Response
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.components.DefaultOutlinedTextField
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.ui.theme.Blue900
import com.mccm.managementapp.presentation.ui.theme.BlueTop
import com.mccm.managementapp.presentation.ui.theme.Green900
import com.mccm.managementapp.presentation.ui.theme.White
import com.mccm.managementapp.presentation.views.login.LoginViewModel

@Composable
fun LoginContent (navController:NavHostController, viewModel: LoginViewModel = hiltViewModel()){

    val state = viewModel.state

    Box(modifier = Modifier
        .fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(BlueTop)
        ){
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    modifier = Modifier
                        .height(160.dp)
                        .padding(top = 10.dp),
                    painter = painterResource(id = R.drawable.log1),
                    contentDescription = "logo")
                Text(modifier = Modifier.padding(12.dp),
                    text = "Management app",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }

        Card(
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp, top = 250.dp)
                .absolutePadding(10.dp),
            border = BorderStroke(3.dp, Color.White)
        ) {
            Column(
                modifier = Modifier
                    .background(color = White)) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    text = "Login",
                    color = Blue900,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                DefaultOutlinedTextField(
                    modifier = Modifier.padding(15.dp),
                    value = state.email,
                    onValueChange = { viewModel.onEmailInput(it) },
                    label = "Email",
                    icon = Icons.Default.Person,
                    keyboardType = KeyboardType.Email,
                    errorMsg = viewModel.emailErrMsg,
                    validateField = {
                        viewModel.validateEmail()
                    }
                )
                DefaultOutlinedTextField(
                    modifier = Modifier.padding(15.dp),
                    value = state.password,
                    onValueChange = { viewModel.onPasswordInput(it) },
                    label = "Password",
                    icon = Icons.Default.Lock,
                    hideText = true,
                    errorMsg = viewModel.passwordlErrMsg,
                    validateField = {
                        viewModel.validatePassword()
                    }
                )

                DefaultButton(modifier = Modifier
                    .fillMaxWidth()
                    .padding(35.dp),
                    text = "Login",
                    onClick = {
                        viewModel.login()
                    },
                    color = Green900,
                    enable = viewModel.isEnableLoginButton
                )
            }
        }

    }
}



