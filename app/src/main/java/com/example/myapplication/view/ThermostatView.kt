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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun ThermostatView(navController: NavController) {
    var isThermostatOn by remember { mutableStateOf(false) }
    var temperature by remember { mutableDoubleStateOf(25.0) }

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
                onClick = { isThermostatOn = !isThermostatOn },
                modifier = Modifier.size(300.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_thermostat),
                    contentDescription = "Термостат",
                    tint = if (isThermostatOn) Color.Magenta else Color.Gray,
                    modifier = Modifier.size(220.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { temperature -= 0.5 },
                    enabled = temperature > 0,
                    modifier = Modifier.size(60.dp)
                ) {
                    Text("-", fontSize = 30.sp)
                }

                Spacer(modifier = Modifier.width(18.dp))

                Text(
                    text = "${temperature}°C",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(horizontal = 18.dp)
                )

                Spacer(modifier = Modifier.width(18.dp))

                Button(
                    onClick = { temperature += 0.5 },
                    modifier = Modifier.size(60.dp)
                ) {
                    Text("+", fontSize = 30.sp)
                }
            }
        }
    }
}