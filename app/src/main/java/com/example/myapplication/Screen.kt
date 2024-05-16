package com.example.myapplication

sealed class Screen (val route: String) {
    object LoginScreen: Screen(route = "login_screen")
    object MainScreen: Screen(route = "home_screen")
    object LampScreen: Screen(route = "lamp_screen")
    object TableLampScreen: Screen(route = "table_lamp_screen")
    object ThermostatScreen: Screen(route = "thermostat_screen")
    object ConditionerScreen: Screen(route = "conditioner_screen")
    object AirHumidifierScreen: Screen(route = "air_humidifier_screen")
    object CurtainsScreen: Screen(route = "curtains_screen")
    object AlarmScreen: Screen(route = "alarm_screen")
    object MulticookerScreen: Screen(route = "multicooker_screen")
    object FanScreen: Screen(route = "fan_screen")
    object SpeakerScreen: Screen(route = "speaker_screen")
    object AirCompositionScreen: Screen(route = "air_composition_screen")
    object PowerSocketScreen: Screen(route = "power_socket_screen")
    object AddAlarmScreen: Screen(route = "add_alarm_screen")
}