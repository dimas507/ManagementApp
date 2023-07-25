package com.mccm.managementapp.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mccm.managementapp.presentation.ui.theme.Indigo900

@Composable
fun DefaultHeaderContentView (
    text: String,
    color: Color = Indigo900,
    spacermodifier: Modifier = Modifier.padding(top = 75.dp),
    fontWeight: FontWeight = FontWeight.Bold
) {
    Spacer(modifier = spacermodifier)
    Text(
        modifier = Modifier.padding(start = 20.dp),
        text = text,
        color = color,
        fontSize = 24.sp,
        fontWeight = fontWeight)
}