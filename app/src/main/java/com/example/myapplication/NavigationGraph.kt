package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.myapplication.view.*

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        //startDestination = Screen.MainScreen.route
        startDestination = Screen.LoginScreen.route
    ) {
        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(navController)
        }

        composable(
            route = Screen.MainScreen.route
        ) {
            MainScreen(navController)
        }

        composable(
            route = Screen.LampScreen.route
        ) {
            LampView(navController)
        }

        composable(
            route = Screen.TableLampScreen.route
        ) {
            TableLampView(navController)
        }

        composable(
            route = Screen.ThermostatScreen.route
        ) {
            ThermostatView(navController)
        }

        composable(
            route = Screen.ConditionerScreen.route
        ) {
            ConditionerView(navController)
        }

        composable(
            route = Screen.AirHumidifierScreen.route
        ) {
            AirHumidifierView(navController)
        }

        composable(
            route = Screen.CurtainsScreen.route
        ) {
            CurtainsView(navController)
        }

        composable(
            route = Screen.AlarmScreen.route
        ) {
            AlarmView(navController)
        }

        composable(
            route = Screen.MulticookerScreen.route
        ) {
            MulticookerView(navController)
        }

        composable(
            route = Screen.FanScreen.route
        ) {
            FanView(navController)
        }

        composable(
            route = Screen.SpeakerScreen.route
        ) {
            SpeakerView(navController)
        }

        composable(
            route = Screen.AirCompositionScreen.route
        ) {
            AirCompositionView(navController)
        }

        composable(
            route = Screen.PowerSocketScreen.route
        ) {
            PowerSocketView(navController)
        }

        composable(
            route = Screen.AddAlarmScreen.route
        ) {
            AddAlarmScreen(navController)
        }
    }
}