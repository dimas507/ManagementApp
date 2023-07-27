package com.mccm.managementapp.presentation.views.annotations.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mccm.managementapp.domain.model.Post
import com.mccm.managementapp.presentation.ui.theme.Indigo900
import com.mccm.managementapp.presentation.ui.theme.LightBlue900

@Composable
fun AnnotationCard (post: Post){
    Spacer(modifier = Modifier.padding(top = 25.dp))
    Card(
        colors = CardDefaults.cardColors(Color.White) ,
        modifier = Modifier.padding(15.dp),
        elevation = CardDefaults.cardElevation(7.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column() {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = post.image,
                contentScale = ContentScale.Crop,
                contentDescription = "")
            Text(
                fontWeight = FontWeight.Bold,
                color = Indigo900,
                modifier = Modifier
                    .padding(top = 15.dp, start = 15.dp,
                    end= 15.dp,
                    bottom = 10.dp),
                text = "Name:" + " " + post.name)
            Text(
                color = LightBlue900,
                text = "Description:" + " " + post.description,
                modifier = Modifier.padding(start = 15.dp, end= 15.dp, bottom = 10.dp),
                fontSize = 13.sp
            )
            Text(
                color = LightBlue900,
                text = "Category:" + " " + post.category,
                modifier = Modifier.padding(start = 15.dp, end= 15.dp, bottom = 10.dp)
            )
        }
    }
}