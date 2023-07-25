package com.mccm.managementapp.presentation.views.animalscourses.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer
import com.mccm.managementapp.domain.model.Datos
import com.mccm.managementapp.presentation.views.animalscourses.AnimalsCoursesViewModel
import kotlin.random.Random


@Composable
fun AnimalsCoursesContent(viewModel: AnimalsCoursesViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Animals Courses Graphics",
            style = MaterialTheme.typography.labelMedium
        )
        Barras()
    }
}

@Composable
fun Barras() {
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
