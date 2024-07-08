package com.example.myapplication.pages

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.components.ContentBox
import com.example.myapplication.components.SearchBar

@Composable
fun Home(navController: NavHostController) {
    Column {
        SearchBar()
        ContentBox() {
            for (i in 1..30) {
                Text(
                    text = "Box-" + i,
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 8.dp)
                        .height(100.dp)
                        .border(1.dp, MaterialTheme.colorScheme.onBackground, shape = RoundedCornerShape(12.dp))
                        .clip(shape = RoundedCornerShape(12.dp))
                        .clickable { }
                        .padding(16.dp),
                    fontWeight = FontWeight.W700,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 26.sp,
                )
            }
        }

    }

}

