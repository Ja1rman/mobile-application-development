package com.example.myapplication.view

import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ButtonDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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

@Composable
fun FanView(navController: NavController) {
    var isFanOn by remember { mutableStateOf(false) }
    var fanPower by remember { mutableIntStateOf(0) } // Мощность вентилятора: 0 - низкая, 1 - средняя, 2 - высокая
    var fanMode by remember { mutableStateOf(FanMode.STATIC) } // Режим работы вентилятора: статичный или динамический

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
                onClick = { isFanOn = !isFanOn }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_fan),
                    contentDescription = "Вентилятор",
                    tint = if (isFanOn) Color.Magenta else Color.Gray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { fanPower = 0 },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (fanPower == 0) Color.Magenta else Color.Gray
                    )
                ) {
                    Text(text = "Низкая")
                }
                Button(
                    onClick = { fanPower = 1 },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (fanPower == 1) Color.Magenta else Color.Gray
                    )
                ) {
                    Text(text = "Средняя")
                }
                Button(
                    onClick = { fanPower = 2 },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (fanPower == 2) Color.Magenta else Color.Gray
                    )
                ) {
                    Text(text = "Высокая")
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { fanMode = FanMode.STATIC },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (fanMode == FanMode.STATIC) Color.Magenta else Color.Gray
                    )
                ) {
                    Text(text = "Статичный")
                }
                Button(
                    onClick = { fanMode = FanMode.DYNAMIC },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (fanMode == FanMode.DYNAMIC) Color.Magenta else Color.Gray
                    )
                ) {
                    Text(text = "Динамический")
                }
            }
        }
    }
}

enum class FanMode {
    STATIC,
    DYNAMIC
}
