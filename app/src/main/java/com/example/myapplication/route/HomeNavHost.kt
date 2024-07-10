package com.example.myapplication.route

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.pages.Help
import com.example.myapplication.pages.Home
import com.example.myapplication.pages.MainPage
import com.example.myapplication.pages.My

@Composable
fun HomeNavHostBox(navController: NavHostController, sysStatusBarHeight: Dp) {
    NavHost(
        navController = navController,
        startDestination = "main",
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {

        composable("main") {
            val activity = (LocalContext.current as? Activity)
            BackHandler {
                activity?.moveTaskToBack(true) // 最小化
            }
            MainPage(navController, sysStatusBarHeight)
        }
//        composable("my") {
//            val activity = (LocalContext.current as? Activity)
//            BackHandler {
//                activity?.moveTaskToBack(true) // 最小化
//            }
//            My(navController)
//        }
        composable("my/help") {
            Help(navController, sysStatusBarHeight)
        }
    }
}
