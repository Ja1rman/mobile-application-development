package com.example.myapplication.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Slider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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
fun SpeakerView(navController: NavController) {
    var isSpeakerOn by remember { mutableStateOf(false) }
    var volume by remember { mutableIntStateOf(50) } // Изначальная громкость

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
                onClick = { isSpeakerOn = !isSpeakerOn }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_speaker),
                    contentDescription = "Колонка",
                    tint = if (isSpeakerOn) Color.Magenta else Color.Gray
                )
            }

            Slider(
                value = volume.toFloat(),
                onValueChange = { value -> volume = value.toInt() },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                    // Действия по завершении изменения громкости
                }
            )

            Row {
                IconButton(
                    onClick = {
                        // Действия по переключению музыки назад
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Назад",
                        modifier = Modifier.size(90.dp)
                    )
                }

                IconButton(
                    onClick = {
                        // Действия по переключению музыки вперед
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Вперед",
                        modifier = Modifier.size(90.dp)
                    )
                }
            }
        }
    }
}