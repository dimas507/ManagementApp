package com.mccm.managementapp.presentation.views.welcome.components.welcomecontentcomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.ui.theme.Gray500
import com.mccm.managementapp.presentation.ui.theme.Indigo900
import com.mccm.managementapp.presentation.views.welcome.WelcomeViewModel

@Composable
fun WelcomeBoxHeader(navController: NavHostController,
                     viewModel: WelcomeViewModel = hiltViewModel()){
    Spacer(modifier = Modifier.padding(top = 30.dp))
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.user_1),
                contentDescription = "User")
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = viewModel.userData.username.uppercase(),
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = viewModel.userData.schoolName.uppercase(),
                    color = Gray500,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = "Welcome!",
            color = Indigo900,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold)
    }
}
