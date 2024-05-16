package com.example.myapplication.view

import androidx.compose.foundation.layout.*
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
fun LampView(navController: NavController) {
    var isLampOn by remember { mutableStateOf(false) }

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
                onClick = { isLampOn = !isLampOn }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_lamp),
                    contentDescription = "Лампочка",
                    tint = if (isLampOn) Color.Magenta else Color.Gray
                )
            }
        }
    }
}
