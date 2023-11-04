package com.example.fooddeliveryapp.bottom_navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fooddeliveryapp.screens.Basket
import com.example.fooddeliveryapp.screens.Menu
import com.example.fooddeliveryapp.screens.Profile

@Composable
fun NavGraph(navController: NavHostController, paddingValue: PaddingValues) {
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            Menu(paddingValue)
        }
        composable("profile") {
            Profile()
        }
        composable("basket") {
            Basket()
        }
    }
}