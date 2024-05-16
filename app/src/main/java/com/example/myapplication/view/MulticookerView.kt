package com.example.myapplication.view

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import java.util.Calendar

@Composable
fun MulticookerView(navController: NavController) {
    var isMulticookerOn by remember { mutableStateOf(false) }
    var startTime by remember { mutableStateOf("00:00") }
    var endTime by remember { mutableStateOf("00:00") }

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
                onClick = { isMulticookerOn = !isMulticookerOn }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_multicooker),
                    contentDescription = "Мультиварка",
                    tint = if (isMulticookerOn) Color.Magenta else Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            TimePickerField("Время начала", startTime) { time ->
                startTime = time
            }

            Spacer(modifier = Modifier.height(16.dp))

            TimePickerField("Время окончания", endTime) { time ->
                endTime = time
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun TimePickerField(label: String, time: String, onTimeSelected: (String) -> Unit) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = label)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = time, modifier = Modifier.clickable {
            showTimePickerDialog(context) { hours, minutes ->
                onTimeSelected(String.format("%02d:%02d", hours, minutes))
            }
        })
    }
}

fun showTimePickerDialog(context: Context, onTimeSelected: (hours: Int, minutes: Int) -> Unit) {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val timePickerDialog = TimePickerDialog(
        context,
        { _, selectedHour, selectedMinute ->
            onTimeSelected(selectedHour, selectedMinute)
        },
        hour,
        minute,
        true
    )
    timePickerDialog.show()
}
