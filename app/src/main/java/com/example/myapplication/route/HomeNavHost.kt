package com.example.myapplication.route

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.VectorProperty
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
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth / 6 }
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth }
            )
        },
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth }
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth / 6 }
            )
        }
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
