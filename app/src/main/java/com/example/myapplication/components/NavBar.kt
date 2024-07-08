package com.example.myapplication.components

/**
 * 底部导航栏
 */
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavBar(navController: NavHostController) {

    Row(
        Modifier
            .fillMaxHeight(),
//            .padding(16.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        NavItem(
            Icons.Filled.Home,
            "home",
            MaterialTheme.colorScheme.onBackground,
            navController,
            navBackStackEntry
        )
        NavItem(
            Icons.Filled.Person,
            "my",
            MaterialTheme.colorScheme.onBackground,
            navController,
            navBackStackEntry
        )
    }
}

@Composable
fun RowScope.NavItem(
    icon: ImageVector,
    name: String,
    color: Color = Color.Black,
    navController: NavHostController,
    currentDestination: NavBackStackEntry?
) {
    Button(
        onClick = {
//            如果当前页面就是name 则不触发跳转
            if (navController.currentDestination?.route != name) {
                navController.navigate(name)
//                {
//                    popUpTo("home") {
//                        inclusive = true
//                    }
//                }
            }
        }, Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(1f),
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.background,
        )
    ) {
        // 判断Active状态
        val isActive = currentDestination?.destination?.route == name
        // 高亮激活的navItem
        val tint = if (isActive) {
            MaterialTheme.colorScheme.primary
        } else {
            color
        }
        Icon(
            icon,
            name,
            Modifier
                .size(28.dp)
                .fillMaxHeight()
                .weight(1f),
            tint = tint,
        )
    }
}


