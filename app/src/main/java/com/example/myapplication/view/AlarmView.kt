package com.example.myapplication.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import kotlin.random.Random


data class Alarm(val id: Int, var time: String, var isEnabled: Boolean)
var alarmList = listOf(
    Alarm(id = 1, time = "08:00", isEnabled = true),
    Alarm(id = 2, time = "12:30", isEnabled = false),
    Alarm(id = 3, time = "18:45", isEnabled = true)
)
@Composable
fun AlarmListView(
    alarmList: List<Alarm>,
    onDeleteClicked: (Alarm) -> Unit,
    onToggleClicked: (Alarm) -> Unit
) {
    LazyColumn {
        items(alarmList) { alarm ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = alarm.time, modifier = Modifier.weight(1f))
                IconButton(onClick = { onDeleteClicked(alarm) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Удалить")
                }
                Switch(
                    checked = alarm.isEnabled,
                    onCheckedChange = { onToggleClicked(alarm) },
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun AlarmView(navController: NavController) {
    val (alarmList, setAlarmList) = remember { mutableStateOf(alarmList) }

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
                .padding(20.dp)
                .fillMaxSize()
        ) {
            AlarmListView(
                alarmList = alarmList,
                onDeleteClicked = { alarm ->
                    setAlarmList(alarmList.filter { it.id != alarm.id })
                },
                onToggleClicked = { alarm ->
                    val updatedList = alarmList.map {
                        if (it.id == alarm.id) {
                            it.copy(isEnabled = !it.isEnabled)
                        } else {
                            it
                        }
                    }
                    setAlarmList(updatedList)
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            FloatingActionButton(
                onClick = { navController.navigate("add_alarm_screen") },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.End)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Добавить будильник")
            }
        }
    }
}

@Composable
fun AddAlarmScreen(navController: NavController) {
    var time by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = time,
            onValueChange = { time = it },
            label = { Text(text = "Time") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val alarm = Alarm(
                    id = Random.nextInt(), // Генерация уникального ID
                    time = time.text,
                    isEnabled = true // По умолчанию включен
                )
                alarmList += alarm
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Add Alarm")
        }
    }
}