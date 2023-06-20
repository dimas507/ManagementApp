package com.mccm.managementapp.presentation.views.courses.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.ui.theme.Indigo900


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesContent(navController: NavHostController) {
    Spacer(modifier = Modifier.width(20.dp))
    Box() {
        Image(
            modifier = Modifier
                .wrapContentWidth(Alignment.End)
                .align(Alignment.TopCenter)
                .fillMaxWidth().size(350.dp),
            painter = painterResource( R.drawable.indigobluemidlecircle),
            contentDescription = "")
    }

    Column(modifier = Modifier
        .padding(start = 30.dp, end = 30.dp, top = 100.dp)) {
        Row() {
            Text(
                modifier = Modifier
                    .wrapContentWidth(Alignment.Start)
                    .weight(1f),
                text = "Science",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            DefaultButton(text = "Begginer",
                onClick = { /*TODO*/ },
                modifier = Modifier,
                color = Color.White,
                tinticon = Indigo900,
                colortext = Indigo900,
                icon = Icons.Filled.Add
            )
        }
        Row(modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(top = 100.dp)) {
            Card(modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .shadow(10.dp),
                border = BorderStroke(4.dp, Color.White),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp),
                onClick = { /*TODO*/ }
            ){
                    Column(modifier = Modifier.padding(30.dp)) {
                        Box(modifier = Modifier.padding(10.dp)){
                            Image(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .zIndex(0f)
                                    .wrapContentWidth(Alignment.End),
                                painter = painterResource(id = R.drawable.white_circle),
                                contentDescription = "Withe Circle")
                            Image(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .zIndex(1f)
                                    .wrapContentWidth(Alignment.End),
                                painter = painterResource(id = R.drawable.animal_log_img),
                                contentDescription = "Animal Log")
                        }
                        Text(modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 10.dp, end = 10.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally),
                            text = "Animal",
                            color = Color.Black,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center)
                        Text(modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            text = "4/5",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold)
                        Image(
                            modifier = Modifier
                                .padding(10.dp)
                                .wrapContentWidth(Alignment.End),
                            painter = painterResource(id = R.drawable.barra_img),
                            contentDescription = "Animal Log")
                    }
            }
            //Eliminar los siguientes y hacer interactivo
            Card(modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .shadow(10.dp),
                border = BorderStroke(4.dp, Color.White),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp),
                onClick = { /*TODO*/ }
            ){
                Column(modifier = Modifier.padding(30.dp)) {
                    Box(modifier = Modifier.padding(10.dp)){
                        Image(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .zIndex(0f)
                                .wrapContentWidth(Alignment.End),
                            painter = painterResource(id = R.drawable.white_circle),
                            contentDescription = "Withe Circle")
                        Image(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .zIndex(1f)
                                .wrapContentWidth(Alignment.End),
                            painter = painterResource(id = R.drawable.plants_img),
                            contentDescription = "Plants Log")
                    }
                    Text(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 10.dp, end = 10.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                        text = "Plants",
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center)
                    Text(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center,
                        text = "3/3",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Image(
                        modifier = Modifier
                            .padding(10.dp)
                            .wrapContentWidth(Alignment.End),
                        painter = painterResource(id = R.drawable.barra_img),
                        contentDescription = "Animal Log")
                }
            }
            Card(modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .shadow(10.dp),
                border = BorderStroke(4.dp, Color.White),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp),
                onClick = { /*TODO*/ }
            ){
                Column(modifier = Modifier.padding(30.dp)) {
                    Box(modifier = Modifier.padding(10.dp)){
                        Image(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .zIndex(0f)
                                .wrapContentWidth(Alignment.End),
                            painter = painterResource(id = R.drawable.white_circle),
                            contentDescription = "Withe Circle")
                        Image(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .zIndex(1f)
                                .wrapContentWidth(Alignment.End),
                            painter = painterResource(id = R.drawable.foods_log_img),
                            contentDescription = "Animal Log")
                    }
                    Text(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 10.dp, end = 10.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                        text = "Animal",
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center)
                    Text(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center,
                        text = "4/5",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Image(
                        modifier = Modifier
                            .padding(10.dp)
                            .wrapContentWidth(Alignment.End),
                        painter = painterResource(id = R.drawable.barra_img),
                        contentDescription = "Animal Log")
                }
            }
            //hasta aqui debo eliminar
        }
    }
}


