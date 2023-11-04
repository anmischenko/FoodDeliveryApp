package com.example.fooddeliveryapp.bottom_navigation

import com.example.fooddeliveryapp.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object Menu: BottomItem("Меню", R.drawable.menu,"menu")
    object Profile: BottomItem("Профиль", R.drawable.profile,"profile")
    object Basket: BottomItem("Корзина", R.drawable.basket,"basket")
}
