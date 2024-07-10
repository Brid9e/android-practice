package com.example.myapplication.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myapplication.components.ContentBox
import com.example.myapplication.components.SearchBar

@Composable
fun Home(navController: NavHostController) {
    Column {
        SearchBar()
        ContentBox() {
//
        }
    }

}

