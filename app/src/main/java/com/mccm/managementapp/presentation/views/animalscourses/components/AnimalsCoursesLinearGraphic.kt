package com.mccm.managementapp.presentation.views.animalscourses.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.line.LineChart
import com.github.tehras.charts.line.LineChartData
import com.github.tehras.charts.line.renderer.line.SolidLineDrawer
import com.mccm.managementapp.domain.model.Datos
import kotlin.random.Random

@Composable
fun AnimalsCoursesLinearGraphic(){
    val datos: List<Datos> = listOf(
        Datos("07-24", Random.nextFloat() * 8),
        Datos("07-25", Random.nextFloat() * 8),
        Datos("07-26", Random.nextFloat() * 8),
        Datos("07-27", Random.nextFloat() * 8),
        Datos("07-28", Random.nextFloat() * 8),
    )

    val puntos = ArrayList<LineChartData.Point>()
    datos.map { dato ->
        puntos.add(LineChartData.Point(
            value = dato.value,
            label = dato.label
        ))
    }
    val lineas = ArrayList<LineChartData>()
    lineas.add(
        LineChartData(
            points = puntos,
            lineDrawer = SolidLineDrawer()
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ,elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.padding(10.dp))
            Text("Productivity over time, last week",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.Black
            )
            LineChart(linesChartData = lineas,
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 80.dp)
                    .height(300.dp)
            )
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}