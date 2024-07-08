package com.example.myapplication.utils

import androidx.compose.ui.graphics.Color

fun hexColor(color: String): Color {
    return Color(android.graphics.Color.parseColor(color))
}