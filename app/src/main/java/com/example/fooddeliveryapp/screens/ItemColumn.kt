package com.example.fooddeliveryapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveryapp.ui.theme.LightTextColor
import com.example.fooddeliveryapp.ui.theme.Line
import com.example.fooddeliveryapp.ui.theme.TextColor
import com.example.fooddeliveryapp.ui.theme.TextPressedButtonColor

@Composable
fun ItemColumn(item: ItemColumnModel) {

    Box(modifier = Modifier.fillMaxWidth()) {
        Divider(color = Line, thickness = 1.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = "Image " + item.title,
                modifier = Modifier.size(135.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = item.title,
                    color = TextColor,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(
                        Font(
                            DeviceFontFamilyName("sans-serif-medium"),
                            weight = FontWeight.Bold
                        )
                    )
                )
                Text(
                    text = item.composition,
                    color = LightTextColor,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(
                        Font(
                            DeviceFontFamilyName("sans-serif-medium")
                        )
                    ),
                    modifier = Modifier.padding(
                        top = 8.dp,
                        bottom = 8.dp
                    )
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(32.dp)
                        .align(Alignment.End),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    border = BorderStroke(1.dp, TextPressedButtonColor)
                ) {
                    Text(
                        text = "от " + item.price.toString() + " р",
                        color = TextPressedButtonColor,
                        fontSize = 13.sp,
                        fontFamily = FontFamily(
                            Font(
                                DeviceFontFamilyName("sans-serif-medium")
                            )
                        )
                    )
                }
            }
        }
    }
}
