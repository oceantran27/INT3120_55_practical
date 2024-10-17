package com.example.flightsearch

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun FlightSearchApp() {
    val navController = rememberNavController()
    Scaffold() { paddingValues ->
        NavHost(
            navController = navController,
        )
    }
}