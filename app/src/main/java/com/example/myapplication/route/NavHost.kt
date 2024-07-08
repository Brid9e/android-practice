package com.example.myapplication.route

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.pages.Home
import com.example.myapplication.pages.My

@Composable
fun NavHostBox(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home",
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
    ) {
//        navOptions() {
//            NavOptions.Builder()
//                .setEnterAnim(0)
//                .setExitAnim(0)
//                .setPopEnterAnim(0)
//                .setPopExitAnim(0)
//                .build()
//        }
        composable("home") {
            Home(navController)
        }
        composable("my") {
            My(navController)
        }
    }
// 禁止所有默认动画

}
