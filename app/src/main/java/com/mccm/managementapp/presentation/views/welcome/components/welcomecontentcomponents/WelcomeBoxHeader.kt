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
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.ui.theme.Gray500
import com.mccm.managementapp.presentation.ui.theme.Indigo900

@Composable
fun WelcomeBoxHeader(){
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
                    text = "Username",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "School name",
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
