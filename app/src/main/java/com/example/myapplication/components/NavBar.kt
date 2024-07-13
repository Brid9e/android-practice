package com.example.myapplication.components

/**
 * 底部导航栏
 */
import androidx.compose.foundation.background
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myapplication.HomeViewModel

@Composable
fun NavBar(activeIndex: Int, onNavClicked: (Int) -> Unit) {
    val viewModel: HomeViewModel = viewModel()
    Row(
        Modifier
            .fillMaxHeight(),
//            .padding(16.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
        NavItem(
            0,
            Icons.Filled.Home,
            "home",
            MaterialTheme.colorScheme.onBackground,
            activeIndex == 0,
        ) { index ->
            onNavClicked(index)
        }
        NavItem(
            1,
            Icons.Filled.Person,
            "my",
            MaterialTheme.colorScheme.onBackground,
            activeIndex == 1
        ) { index ->
            onNavClicked(index)
        }
    }
}

@Composable
fun RowScope.NavItem(
    index: Int,
    icon: ImageVector,
    name: String,
    color: Color = Color.Black,
    isActive: Boolean,
    onNavClicked: (Int) -> Unit = {}
) {
    Button(
        onClick = {
            onNavClicked(index)
//            如果当前页面就是name 则不触发跳转
//            if (navController.currentDestination?.route != name) {
//                navController.navigate(name) {
//                    launchSingleTop = true
//                }
////                {
////                    popUpTo("home") {
////                        inclusive = true
////                    }
////                }
//            }
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
        Icon(
            icon,
            name,
            Modifier
                .size(28.dp)
                .fillMaxHeight()
                .weight(1f),
            // 高亮激活的navItem
            tint = if (isActive) {
                MaterialTheme.colorScheme.primary
            } else {
                color
            },
        )
    }
}


