package com.example.myapplication.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myapplication.components.CellGroup
import com.example.myapplication.components.ContentBox
import com.example.myapplication.components.UserInfoCard
import com.example.myapplication.data.SettingsData

@Composable
fun My(navController: NavHostController) {
    Column {
        UserInfoCard()
        ContentBox { CellGroup(SettingsData, navController) }
    }
}