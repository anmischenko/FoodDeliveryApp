package com.example.fooddeliveryapp.bottom_navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.fooddeliveryapp.ui.theme.BackgroundBottom
import com.example.fooddeliveryapp.ui.theme.BottomColor
import com.example.fooddeliveryapp.ui.theme.TextPressedButtonColor

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val screens = listOf(
        BottomItem.Menu,
        BottomItem.Profile,
        BottomItem.Basket
    )
    NavigationBar(containerColor = BackgroundBottom) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = { navController.navigate(screen.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconId),
                        contentDescription = screen.title
                    )
                },
                label = {
                    Text(text = screen.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = BottomColor,
                    unselectedIconColor = BottomColor,
                    selectedTextColor = TextPressedButtonColor,
                    selectedIconColor = TextPressedButtonColor,
                    indicatorColor = BackgroundBottom
                ),
            )
        }
    }
}