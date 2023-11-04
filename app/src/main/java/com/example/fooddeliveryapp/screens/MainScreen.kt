package com.example.fooddeliveryapp.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddeliveryapp.bottom_navigation.BottomNavigationBar
import com.example.fooddeliveryapp.bottom_navigation.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }) {
        NavGraph(navController = navController, paddingValue = it)

    }
}