package com.mccm.managementapp.presentation.views.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.navigation.AppScreen
import com.mccm.managementapp.presentation.ui.theme.Green900
import com.mccm.managementapp.presentation.views.profile.ProfileViewModel

@Composable
fun ProfileContent (navController: NavHostController,
                    viewModel: ProfileViewModel = hiltViewModel()) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box{
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(313.dp),
                painter = painterResource(
                id = R.drawable.indigobluemidlecircle),
                contentDescription = "")
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(70.dp))
                Text(text = "Profile",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    modifier = Modifier
                        .size(125.dp),
                    painter = painterResource(id = R.drawable.user_1),
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.height(55.dp))
        Text(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            text = viewModel.userData.username,
            color = Color.Black
        )
        Text(
            fontSize = 15.sp,
            fontStyle = FontStyle.Italic,
            text = viewModel.userData.email,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))
        DefaultButton(
            text = "Edit data",
            onClick = { navController.navigate(route = AppScreen.ProfileEdit.route) },
            modifier = Modifier.width(200.dp),
            color = Green900
        )
        
        Spacer(modifier = Modifier.height(15.dp))
        DefaultButton(
            text = "Logout",
            onClick = { viewModel.logout()
                navController.navigate(route = AppScreen.Login.route){
                    popUpTo(AppScreen.Welcome.route){inclusive = true}
                }
            },
            modifier = Modifier.width(200.dp),
            color = Color.Red
        )
    }
}


