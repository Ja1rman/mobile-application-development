package com.example.myapplication.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*

@Composable
fun AirHumidifierView(navController: NavController) {
    var isAirHumidifierOn by remember { mutableStateOf(false) }
    var fanSpeed1 by remember { mutableStateOf(true) }
    var fanSpeed2 by remember { mutableStateOf(false) }
    var fanSpeed3 by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.navigateUp() },
            modifier = Modifier
                .size(64.dp) // Уменьшаем размер кнопки
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
                onClick = { isAirHumidifierOn = !isAirHumidifierOn },
                modifier = Modifier.size(300.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_air_humidifier),
                    contentDescription = "Увлажнитель",
                    tint = if (isAirHumidifierOn) Color.Magenta else Color.Gray,
                    modifier = Modifier.size(220.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        fanSpeed1 = !fanSpeed1
                        fanSpeed2 = false
                        fanSpeed3 = false
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (fanSpeed1) Color.Magenta else Color.LightGray)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_low),
                        contentDescription = "Низкая"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Низкая")
                }

                Button(
                    onClick = {
                        fanSpeed1 = false
                        fanSpeed2 = !fanSpeed2
                        fanSpeed3 = false
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (fanSpeed2) Color.Magenta else Color.LightGray)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_medium),
                        contentDescription = "Средняя"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Средняя")
                }

                Button(
                    onClick = {
                        fanSpeed1 = false
                        fanSpeed2 = false
                        fanSpeed3 = !fanSpeed3
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (fanSpeed3) Color.Magenta else Color.LightGray)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_high),
                        contentDescription = "Высокая"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Высокая")
                }
            }
        }
    }
}