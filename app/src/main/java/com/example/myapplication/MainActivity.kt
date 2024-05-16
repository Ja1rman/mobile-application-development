package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Создайте объект NavController для управления навигацией
            val navController = rememberNavController()

            // Устанавливаем NavHost с начальным экраном LoginScreen
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Перенаправление на главный экран после нажатия на кнопку "Login"
                navController.navigate(route = Screen.MainScreen.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Главный экран")
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(buttonItems.size) { index ->
                val item = buttonItems[index]
                GridButton(
                    text = item.text,
                    painter = painterResource(id = item.imageResId),
                    onClick = {
                        navController.navigate(route = item.route)
                    }
                )
            }
        }
    }
}

@Composable
fun GridButton(text: String, painter: Painter, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text)
        }
    }
}
data class ButtonItem(val text: String, val imageResId: Int, val route: String)

val buttonItems = listOf(
    ButtonItem("Лампочка", R.drawable.ic_lamp, "lamp_screen"),
    ButtonItem("Настольная лампа", R.drawable.ic_table_lamp, "table_lamp_screen"),
    ButtonItem("Термостат", R.drawable.ic_thermostat, "thermostat_screen"),
    ButtonItem("Кондиционер", R.drawable.ic_conditioner, "conditioner_screen"),
    ButtonItem("Увлажнитель Воздуха", R.drawable.ic_air_humidifier, "air_humidifier_screen"),
    ButtonItem("Шторы", R.drawable.ic_curtains, "curtains_screen"),
    ButtonItem("Будильник", R.drawable.ic_alarm, "alarm_screen"),
    ButtonItem("Мультиварка", R.drawable.ic_multicooker, "multicooker_screen"),
    ButtonItem("Вентилятор", R.drawable.ic_fan, "fan_screen"),
    ButtonItem("Колонка", R.drawable.ic_speaker, "speaker_screen"),
    ButtonItem("Состав воздуха", R.drawable.ic_air_composition, "air_composition_screen"),
    ButtonItem("Умная розетка", R.drawable.ic_power_socket, "power_socket_screen"),
)