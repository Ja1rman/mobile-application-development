package com.example.myapplication

sealed class Screen (val route: String) {
    data object LoginScreen: Screen(route = "login_screen")
    data object MainScreen: Screen(route = "home_screen")
    data object LampScreen: Screen(route = "lamp_screen")
    data object TableLampScreen: Screen(route = "table_lamp_screen")
    data object ThermostatScreen: Screen(route = "thermostat_screen")
    data object ConditionerScreen: Screen(route = "conditioner_screen")
    data object AirHumidifierScreen: Screen(route = "air_humidifier_screen")
    data object CurtainsScreen: Screen(route = "curtains_screen")
    data object AlarmScreen: Screen(route = "alarm_screen")
    data object MulticookerScreen: Screen(route = "multicooker_screen")
    data object FanScreen: Screen(route = "fan_screen")
    data object SpeakerScreen: Screen(route = "speaker_screen")
    data object AirCompositionScreen: Screen(route = "air_composition_screen")
    data object PowerSocketScreen: Screen(route = "power_socket_screen")
    data object AddAlarmScreen: Screen(route = "add_alarm_screen")
}
