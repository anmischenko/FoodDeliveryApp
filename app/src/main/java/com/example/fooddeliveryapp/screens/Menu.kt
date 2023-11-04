package com.example.fooddeliveryapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.ui.theme.TextColor
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(paddingValue: PaddingValues) {
    val cities = listOf("Москва", "Санкт-Петербург", "Киев")
    val selectedCity = remember { mutableStateOf(cities[0]) }
    val isMenuExpanded = remember { mutableStateOf(false) }
    val state = rememberCollapsingToolbarScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Button(
                    onClick = {
                        isMenuExpanded.value = true
                    }, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Row {
                        Text(
                            text = selectedCity.value,
                            color = TextColor,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(
                                Font(
                                    DeviceFontFamilyName("sans-serif-medium"),
                                    weight = FontWeight.Medium
                                )
                            )
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.keyboard_arrow_down),
                            contentDescription = "keyboard arrow down",
                            tint = TextColor
                        )
                    }

                }
                DropdownMenu(
                    expanded = isMenuExpanded.value,
                    onDismissRequest = { isMenuExpanded.value = false }
                ) {
                    cities.forEach { city ->
                        DropdownMenuItem(text = {
                            Text(text = city)
                        },
                            onClick = {
                                selectedCity.value = city
                                isMenuExpanded.value = false
                            })
                    }
                }
            },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.qr_code),
                            contentDescription = "qr code",
                            tint = TextColor
                        )
                    }
                }
            )
        }
    ) {
        CollapsingToolbarScaffold(
            modifier = Modifier.padding(
                top = it.calculateTopPadding()
            ),
            state = state,
            scrollStrategy = ScrollStrategy.EnterAlways,
            toolbar = {
                Column {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        itemsIndexed(
                            listOf(
                                BannerRowModel(R.drawable.banner1, "banner1"),
                                BannerRowModel(R.drawable.banner2, "banner2")
                            )
                        ) { _, item ->
                            BannerRow(item = item)
                        }
                    }
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 24.dp,
                                start = 8.dp,
                                bottom = 16.dp
                            )
                    ) {
                        itemsIndexed(
                            listOf(
                                CategoryRowModel("Пицца"),
                                CategoryRowModel("Комбо"),
                                CategoryRowModel("Десерты"),
                                CategoryRowModel("Напитки")
                            )
                        ) { _, item ->
                            CategoryRow(item = item)
                        }
                    }
                }

            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValue)
            ) {
                itemsIndexed(
                    listOf(
                        ItemColumnModel(
                            R.drawable.pizza1,
                            "Ветчина и грибы",
                            "Ветчина, шампиньоны, увеличинная порция моцареллы, томатный соус",
                            345
                        ),
                        ItemColumnModel(
                            R.drawable.pizza2,
                            "Баварские колбаски",
                            "Баварские колбаски, ветчина, пикантная пепперони, острая чоризо, томатный соус",
                            345
                        ),
                        ItemColumnModel(
                            R.drawable.pizza2,
                            "Нежный лосось",
                            "Лосось, томаты, оливки, соус песто, помидорки черри",
                            345
                        ),
                        ItemColumnModel(
                            R.drawable.pizza1,
                            "Ветчина и грибы",
                            "Ветчина, шампиньоны, увеличинная порция моцареллы, томатный соус",
                            345
                        ),
                        ItemColumnModel(
                            R.drawable.pizza1,
                            "Ветчина и грибы",
                            "Ветчина, шампиньоны, увеличинная порция моцареллы, томатный соус",
                            345
                        )

                    )
                ) { _, item ->
                    ItemColumn(item = item)
                }
            }

        }
    }


}