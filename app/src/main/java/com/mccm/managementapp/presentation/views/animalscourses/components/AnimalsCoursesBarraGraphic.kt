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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer
import com.mccm.managementapp.domain.model.Datos
import kotlin.random.Random


@Composable
fun AnimalsCoursesBarraGraphic() {
    val datos: List<Datos> = listOf(
        Datos("Ene", Random.nextFloat() * 20),
        Datos("Feb", Random.nextFloat() * 20),
        Datos("Marzo", Random.nextFloat() * 20),
        Datos("Abril", Random.nextFloat() * 20),
    )
    var barras = ArrayList<BarChartData.Bar>()
    datos.mapIndexed{index, datos ->
        barras.add(
            BarChartData.Bar(
                label = datos.label,
                value = datos.value,
                color = Color.Blue
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
            Text("Time of use in months VS days",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.Black
            )
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
