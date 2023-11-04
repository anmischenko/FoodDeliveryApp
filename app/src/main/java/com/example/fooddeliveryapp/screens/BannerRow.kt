package com.example.fooddeliveryapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun BannerRow(item: BannerRowModel) {
    Box(modifier = Modifier.padding(start = 16.dp)) {
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = item.title,
            modifier = Modifier.width(300.dp),
            contentScale = ContentScale.Crop
        )
    }
}