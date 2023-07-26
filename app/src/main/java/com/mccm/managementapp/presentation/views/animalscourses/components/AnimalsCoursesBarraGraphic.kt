package com.mccm.managementapp.presentation.views.animalscourses.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer
import com.mccm.managementapp.domain.model.Datos
import com.mccm.managementapp.presentation.ui.theme.Blue900
import kotlin.random.Random

@Composable
fun AnimalsCoursesBarraGraphic() {
    var showDays by remember { mutableStateOf(false) }

    val datosMeses: List<Datos> = listOf(
        Datos("Jan", Random.nextFloat() * 20),
        Datos("Feb", Random.nextFloat() * 20),
        Datos("March", Random.nextFloat() * 20),
        Datos("Apr", Random.nextFloat() * 20),
        Datos("May", Random.nextFloat() * 20),
        Datos("Jun", Random.nextFloat() * 20),
        Datos("Jul", Random.nextFloat() * 20),
    )

    val datosDias: List<Datos> = listOf(
        Datos("Mon", Random.nextFloat() * 14),
        Datos("Tue", Random.nextFloat() * 14),
        Datos("Wed", Random.nextFloat() * 14),
        Datos("Thu", Random.nextFloat() * 14),
        Datos("Fri", Random.nextFloat() * 14),
    )

    val datos = if (showDays) datosDias else datosMeses

    val barras = ArrayList<BarChartData.Bar>()
    datos.mapIndexed{ _, datos ->
        barras.add(
            BarChartData.Bar(
                label = datos.label,
                value = datos.value,
                color = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            )
        )
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
            Text("Time of use",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.Black
            )
            Button(
                modifier = Modifier.padding(start = 30.dp, top = 20.dp),
                colors = ButtonDefaults.buttonColors(Blue900),
                onClick = { showDays = !showDays }) {
                Text(if (showDays) "Show Months" else "Show last week", color = Color.White)
            }
            BarChart(barChartData = BarChartData(
                bars = barras
            ),
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 80.dp)
                    .height(300.dp),
                labelDrawer = SimpleValueDrawer(
                    drawLocation = SimpleValueDrawer.DrawLocation.XAxis)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AnimalsCoursesBarraGraphicPreview() {
    AnimalsCoursesBarraGraphic()
}
