package com.example.myapplication.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInclusive
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LiveHelp
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.ui.graphics.vector.ImageVector

data class Settings(val name: String, val route: String, val icon: ImageVector)

val SettingsData = arrayOf(
    Settings("空间", "", Icons.Filled.AllInclusive),
    Settings("设置", "", Icons.Outlined.Tune),
    Settings("帮助", "my/help", Icons.Outlined.LiveHelp),
    Settings("关于", "", Icons.Outlined.Info),
)