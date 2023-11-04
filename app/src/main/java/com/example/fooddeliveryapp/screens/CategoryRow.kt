package com.example.fooddeliveryapp.screens

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveryapp.ui.theme.ButtonColor
import com.example.fooddeliveryapp.ui.theme.TextButtonColor
import com.example.fooddeliveryapp.ui.theme.TextPressedButtonColor

@Composable
fun CategoryRow(item: CategoryRowModel) {
    val selectedCategory = remember { mutableStateOf(false) }
    Button(
        onClick = { selectedCategory.value = !selectedCategory.value },
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.height(32.dp)
            .padding(start = 8.dp),
        colors = ButtonDefaults.buttonColors( containerColor =
            if (selectedCategory.value) ButtonColor else Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp
        )
    ) {
        Text(
            text = item.name,
            color = if (selectedCategory.value) TextPressedButtonColor else TextButtonColor,
            fontSize = 13.sp,
            fontFamily = FontFamily(
                Font(
                    DeviceFontFamilyName("sans-serif-medium")
                )
            )
        )
    }


//    val isSelected = remember { mutableStateOf(false) }
//
//    Button(
//        onClick = { isSelected.value = !isSelected.value },
//        modifier = Modifier
//            .padding(16.dp)
//            .background(if (isSelected.value) Color.Red else MaterialTheme.colors.primary)
//    ) {
//        // Текст кнопки
//    }
}