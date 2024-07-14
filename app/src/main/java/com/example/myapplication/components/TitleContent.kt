package com.example.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TitleContent(
    title: String,
    useDefaultPadding: Boolean = true,
    content: @Composable () -> Unit
) {
    Column(Modifier.padding(horizontal = if (useDefaultPadding) 16.dp else 0.dp).padding(bottom = 8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight(700),
            modifier = Modifier.padding(
                horizontal = if (useDefaultPadding) 0.dp else 16.dp,
                vertical = 16.dp
            )
        )
        content()
    }

}