package com.example.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Panel(page: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(180.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primary)
            .clickable { }
    ) {
        Column {
            Text(
                text = "Panel",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 80.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )
            Text(
                text = "SUB",
                color = MaterialTheme.colorScheme.onPrimary.copy(0.8f),
                fontSize = 50.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(start = 16.dp)
            )
        }

    }
}