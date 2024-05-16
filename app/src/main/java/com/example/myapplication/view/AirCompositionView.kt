package com.example.myapplication.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun AirCompositionView(navController: NavController) {
    var isAirCompositionOn by remember { mutableStateOf(false) }

    // State для хранения информации о составе воздуха
    var airComposition by remember { mutableStateOf(AirComposition()) }

    // Эффект для обновления информации каждые 20 секунд
    LaunchedEffect(Unit) {
        while (true) {
            airComposition = generateRandomAirComposition()
            delay(20000) // Пауза в 20 секунд
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.navigateUp() },
            modifier = Modifier
                .size(64.dp)
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back_arrow),
                contentDescription = "Назад"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = { isAirCompositionOn = !isAirCompositionOn }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_air_composition),
                    contentDescription = "Состав воздуха",
                    tint = if (isAirCompositionOn) Color.Magenta else Color.Gray
                )
            }

            // Вывод информации о составе воздуха, если включено
            if (isAirCompositionOn) {
                AirCompositionInfo(airComposition)
            }
        }
    }
}

// Класс для хранения информации о составе воздуха
data class AirComposition(
    val temperature: Float = 0f,
    val particles: Int = 0,
    val pressure: Float = 0f,
    val humidity: Float = 0f
)

// Функция для генерации случайных данных о составе воздуха
fun generateRandomAirComposition(): AirComposition {
    return AirComposition(
        temperature = Random.nextFloat() * 100, // Генерация температуры от 0 до 100
        particles = Random.nextInt(100, 10000), // Генерация количества частиц от 100 до 10000
        pressure = Random.nextFloat() * 1000, // Генерация давления от 0 до 1000
        humidity = Random.nextFloat() * 100 // Генерация влажности от 0 до 100
    )
}

// @Composable для отображения информации о составе воздуха
@Composable
fun AirCompositionInfo(airComposition: AirComposition) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Температура: ${airComposition.temperature} °C")
            Text("Количество частиц: ${airComposition.particles}")
            Text("Давление: ${airComposition.pressure} мм рт. ст.")
            Text("Влажность: ${airComposition.humidity}%")
        }
    }
}
