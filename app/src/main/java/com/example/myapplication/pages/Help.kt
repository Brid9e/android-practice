package com.example.myapplication.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.components.ContentBox

@Composable
fun Help(navController: NavHostController, sysStatusBarHeight: Dp) {
    Surface(Modifier.padding(top = sysStatusBarHeight)) {
        Column {
            ContentBox() {
                repeat(30) {
                    Text(
                        text = "HELP",
                        fontSize = 80.sp,
                        fontWeight = FontWeight(900)
                    )
                }
            }
        }
    }

}