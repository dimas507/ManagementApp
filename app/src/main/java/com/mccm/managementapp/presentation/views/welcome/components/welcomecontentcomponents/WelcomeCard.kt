package com.mccm.managementapp.presentation.views.welcome.components.welcomecontentcomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.ui.theme.Blue900
import com.mccm.managementapp.presentation.ui.theme.Indigo900
import com.mccm.managementapp.presentation.ui.theme.ManagementAppTheme
import com.mccm.managementapp.presentation.ui.theme.White

@Composable
fun WelcomeCard(){
    Spacer(modifier = Modifier.width(20.dp))
    Card(modifier = Modifier
        .padding(start = 30.dp, end = 30.dp)
        .fillMaxWidth()
        .shadow(10.dp),
        border = BorderStroke(4.dp, Color.White),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(7.dp)
    ) {
        Column(modifier = Modifier
            .padding(15.dp)
            .background(color = White)) {
            Spacer(modifier = Modifier.padding(top = 15.dp))
            DefaultButton(text = "Begginer", onClick = { /*TODO*/ }, modifier = Modifier
                .size(width = 140.dp, height = 40.dp))
            Row {
                Column(modifier = Modifier
                    .weight(1f)) {
                    Text(
                        modifier = Modifier
                            .padding( top = 50.dp)
                            .wrapContentWidth(Alignment.Start)
                            .align(Alignment.CenterHorizontally),
                        text = "Animals",
                        color = Indigo900,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.4.em
                    )
                    Text(
                        modifier = Modifier
                            .paddingFromBaseline(0.dp)
                            .padding(start = 4.dp, top = 15.dp, end = 15.dp)
                            .wrapContentWidth(Alignment.Start),
                        text = "Take this lesson to earn a new milestone ",
                        color = Blue900,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.0.em
                    )
                }
                Box(modifier = Modifier){
                    Image(
                        modifier = Modifier
                            .zIndex(0f)
                            .wrapContentWidth(Alignment.End),
                        painter = painterResource(id = R.drawable.blue_circle),
                        contentDescription = "Circle")
                    Image(
                        modifier = Modifier
                            .zIndex(1f)
                            .wrapContentWidth(Alignment.End),
                        painter = painterResource(id = R.drawable.teacher_learning),
                        contentDescription = "Teacher")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWelcomeCard() {
    ManagementAppTheme {
        WelcomeCard()
    }
}