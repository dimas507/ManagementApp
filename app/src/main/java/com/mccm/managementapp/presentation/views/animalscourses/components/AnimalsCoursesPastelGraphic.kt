package com.mccm.managementapp.presentation.views.animalscourses.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer
import com.mccm.managementapp.domain.model.Datos
import com.mccm.managementapp.presentation.ui.theme.Blue900
import com.mccm.managementapp.presentation.ui.theme.Green900
import com.mccm.managementapp.presentation.ui.theme.Orange200
import com.mccm.managementapp.presentation.ui.theme.Purple40
import com.mccm.managementapp.presentation.ui.theme.Yellow200
import kotlin.random.Random

/*
@Composable
fun AnimalsCoursesPastelGraphic()  {

    val datos: List<Datos> = listOf(
        Datos("Act1", Random.nextFloat() * 100),
        Datos("Act2", Random.nextFloat() * 100),
        Datos("Act3", Random.nextFloat() * 100),
        Datos("Act4", Random.nextFloat() * 100),
        Datos("Act5", Random.nextFloat() * 100),
    )

    val slices = ArrayList<PieChartData.Slice>()
    val colors = ArrayList<Color>()
    datos.mapIndexed{ _, datos ->
        val color = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        colors.add(color)
        slices.add(PieChartData.Slice(
            value = datos.value,
            color = color
        ))
    }

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
            Text("activities carried out",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.Black
            )
            PieChart(pieChartData = PieChartData(
                slices = slices
            ),
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 80.dp)
                    .height(300.dp),
                sliceDrawer = SimpleSliceDrawer(
                    sliceThickness = 100f
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}
*/


@Composable
fun DataLegend(datos: List<Datos>, colors: List<Color>) {
    val total = datos.sumOf { it.value.toDouble() }
    Box(modifier = Modifier.height(200.dp)) {
        LazyColumn {
            items(datos) { dato ->
                val percentage = (dato.value / total) * 100
                DataLegendRow(dato, colors[datos.indexOf(dato)], percentage)
            }
        }
    }
}

@Composable
fun DataLegendRow(dato: Datos, color: Color, percentage: Double) {
    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .size(15.dp)
                .background(color)
        )
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "${dato.label}: ${String.format("%.2f", percentage)}% of the activity" ,
            style = TextStyle(
                fontSize = 12.sp),
            color = Color.Black
        )
    }
}

@Composable
fun AnimalsCoursesPastelGraphic()  {

    val datos: List<Datos> = listOf(
        Datos("Act1", Random.nextFloat() * 100),
        Datos("Act2", Random.nextFloat() * 100),
        Datos("Act3", Random.nextFloat() * 100),
        Datos("Act4", Random.nextFloat() * 100),
        Datos("Act5", Random.nextFloat() * 100)
    )

    val slices = ArrayList<PieChartData.Slice>()
    val colors = listOf(Orange200, Green900, Blue900, Purple40, Yellow200)
    datos.mapIndexed{ index, datos ->
        slices.add(PieChartData.Slice(
            value = datos.value,
            color = colors[index]
        ))
    }

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
            Text("Activities carried ut",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.Black
            )
            PieChart(pieChartData = PieChartData(
                slices = slices
            ),
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 80.dp)
                    .height(300.dp),
                sliceDrawer = SimpleSliceDrawer(
                    sliceThickness = 50f
                )
            )
            DataLegend(datos, colors)
        }
    }
}
