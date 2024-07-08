package com.example.myapplication.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInclusive
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LiveHelp
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.ui.graphics.vector.ImageVector

data class Settings(val name: String, val icon: ImageVector)

val SettingsData = arrayOf(
    Settings("Zone", Icons.Filled.AllInclusive),
    Settings("Setting", Icons.Outlined.Tune),
    Settings("Help", Icons.Outlined.LiveHelp),
    Settings("About", Icons.Outlined.Info),
)