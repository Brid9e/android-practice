package com.example.myapplication.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

@Composable
fun FullImage(imageUrl: String, desc: String = "") {
    val painter = rememberAsyncImagePainter(model = imageUrl)
    Image(
        painter = painter,
        contentDescription = desc,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth
    )
}
