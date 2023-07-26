package com.mccm.managementapp.presentation.views.animalscourses.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.ui.theme.Pink40
import com.mccm.managementapp.presentation.ui.theme.White

@Composable
fun AnimalsCoursesHeader() {
    Spacer(modifier =  Modifier.padding(top = 75.dp))
    Card(modifier = Modifier
        .padding(start = 30.dp, end = 30.dp)
        .fillMaxWidth()
        .shadow(10.dp),
        border = BorderStroke(4.dp, Color.White),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(7.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .background(color = White)
        ) {
            DefaultButton(text = "Activities performed",
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier =  Modifier.padding(top = 25.dp))
            DefaultButton(text = "Grading table by activity",
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                color = Pink40
            )
        }
    }
}

