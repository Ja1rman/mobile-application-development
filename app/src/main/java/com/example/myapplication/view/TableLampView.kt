package com.example.myapplication.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
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

@Composable
fun TableLampView(navController: NavController) {
    var isLampOn by remember { mutableStateOf(false) }
    var warmth by remember { mutableFloatStateOf(0.5f) }

    val lampColor = Color(
        red = warmth,
        green = warmth * 0.5f,
        blue = 1 - warmth
    )

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
                onClick = { isLampOn = !isLampOn },
                modifier = Modifier.size(400.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(320.dp)
                        .border(
                            width = 2.dp,
                            color = lampColor,
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_table_lamp),
                        contentDescription = "Лампочка",
                        tint = if (isLampOn) lampColor else Color.Gray,
                        modifier = Modifier.size(240.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Slider(
                value = warmth,
                onValueChange = { warmth = it },
                valueRange = 0f..1f,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}
