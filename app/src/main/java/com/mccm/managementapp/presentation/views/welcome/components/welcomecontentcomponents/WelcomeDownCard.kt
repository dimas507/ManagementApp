package com.mccm.managementapp.presentation.views.welcome.components.welcomecontentcomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.ui.theme.Blue400
import com.mccm.managementapp.presentation.ui.theme.Green400
import com.mccm.managementapp.presentation.ui.theme.ManagementAppTheme
import com.mccm.managementapp.presentation.ui.theme.Orange400

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeDownCard() {
    Spacer(modifier = Modifier
        .padding(top = 20.dp))
    Column(modifier = Modifier
        .padding(start = 30.dp, end = 30.dp)) {
        Text(
            modifier = Modifier
                .wrapContentWidth(Alignment.Start),
            text = "Your courses",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .padding(top = 20.dp))
        Row(modifier = Modifier
            .horizontalScroll(rememberScrollState())) {
            Card(modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .shadow(10.dp),
                border = BorderStroke(4.dp, Orange400),
                colors = CardDefaults.cardColors(Orange400),
                elevation = CardDefaults.cardElevation(7.dp),
                onClick = { /*TODO*/ }
            ){
                    Row() {
                        Column() {
                            Text(modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp)
                                .wrapContentWidth(Alignment.Start),
                                text = "Animal",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold)
                            Text(modifier = Modifier
                                .padding(start = 10.dp)
                                .wrapContentWidth(Alignment.Start),
                                text = "Beginer",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold)
                        }
                        Image(
                            modifier = Modifier.wrapContentWidth(Alignment.End) ,
                            painter = painterResource( R.drawable.white_circle)
                            ,contentDescription = "")
                    }
            }
            //Eliminar los siguientes y hacer interactivo
            Card(modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .shadow(10.dp),
                border = BorderStroke(4.dp, Blue400),
                colors = CardDefaults.cardColors(Blue400),
                elevation = CardDefaults.cardElevation(7.dp),
                onClick = { /*TODO*/ }
            ){
                Row() {
                    Column() {
                        Text(modifier = Modifier
                            .padding(start = 10.dp, top = 10.dp)
                            .wrapContentWidth(Alignment.Start),
                            text = "Foods",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold)
                        Text(modifier = Modifier
                            .padding(start = 10.dp)
                            .wrapContentWidth(Alignment.Start),
                            text = "Beginer",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Image(
                        modifier = Modifier.wrapContentWidth(Alignment.End) ,
                        painter = painterResource( R.drawable.white_circle)
                        ,contentDescription = "")
                }
            }
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Card(modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .shadow(10.dp),
                border = BorderStroke(4.dp, Green400),
                colors = CardDefaults.cardColors(Green400),
                elevation = CardDefaults.cardElevation(7.dp),
                onClick = { /*TODO*/ }
            ){
                Row() {
                    Column() {
                        Text(modifier = Modifier
                            .padding(start = 10.dp, top = 10.dp)
                            .wrapContentWidth(Alignment.Start),
                            text = "Plants",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold)
                        Text(modifier = Modifier
                            .padding(start = 10.dp)
                            .wrapContentWidth(Alignment.Start),
                            text = "Beginer",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Image(
                        modifier = Modifier.wrapContentWidth(Alignment.End) ,
                        painter = painterResource( R.drawable.white_circle)
                        ,contentDescription = "")
                }
            }
        }

        DefaultButton(text = "All courses"
            , onClick = { /*TODO*/ }
            , modifier = Modifier
                .padding(top = 30.dp, start = 20.dp ,end = 20.dp)
            .size(width = 300.dp, height = 40.dp))

        Card(modifier = Modifier
            .padding(top = 30.dp, start = 20.dp ,end = 20.dp)
            .shadow(10.dp)
            .fillMaxWidth(),
            border = BorderStroke(4.dp, Color.White),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(7.dp),
        ){
            Row() {
                Image(
                    modifier = Modifier
                        .wrapContentWidth(Alignment.End)
                        .padding(top = 20.dp)
                        .size(100.dp),
                    painter = painterResource( R.drawable.message_day)
                    ,contentDescription = "")
                Column(modifier = Modifier.padding(end = 10.dp)) {
                    Text(modifier = Modifier
                        .padding(start = 10.dp, top = 20.dp)
                        .wrapContentWidth(Alignment.Start),
                        text = "Message of the day",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.0.em
                    )
                    Text(modifier = Modifier
                        .paddingFromBaseline(top = 30.dp)
                        .padding(start = 10.dp, end = 10.dp)
                        .wrapContentWidth(Alignment.Start),
                        text = "Failure is temporary and natural. Do not get yourself down by one.",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.2.em)
                }
            }
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWelcomeDownCard() {
    ManagementAppTheme {
        WelcomeDownCard()
    }
}