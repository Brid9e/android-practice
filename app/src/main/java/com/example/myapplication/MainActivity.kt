package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.components.NavBar
import com.example.myapplication.pages.Home
import com.example.myapplication.pages.MainPage
import com.example.myapplication.pages.My
import com.example.myapplication.route.HomeNavHostBox
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val systemUiController = rememberSystemUiController()
                val statusBarColor = MaterialTheme.colorScheme.background
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = statusBarColor, // Set your desired status bar color
                    )
                }
                val sysStatusBarHeight =
                    androidx.compose.foundation.layout.WindowInsets.statusBars.asPaddingValues()
                        .calculateTopPadding()
                val navController = rememberNavController()
                PageMain(navController, sysStatusBarHeight)
//                PressBackAgainToExit(navController)
            }
        }
    }

    /**
     * * 按两次返回键退出应用
     */
//    private var pressedTime: Long = 0
//
//    @Deprecated("Deprecated in Java")
//    override fun onBackPressed() {
//        if (pressedTime + 2000 > System.currentTimeMillis()) {
//            super.onBackPressed()
//            finish()
//        } else {
//            Toast.makeText(baseContext, "请再按一次退出", Toast.LENGTH_SHORT).show()
//        }
//        pressedTime = System.currentTimeMillis()
//    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PageMain(navController: NavHostController, sysStatusBarHeight: Dp) {
    HomeNavHostBox(navController, sysStatusBarHeight)
}

//@Composable
//fun PressBackAgainToExit(navController: NavHostController) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val needExitRouteArr = arrayOf("login", "register", "home", "my")
//    if (!needExitRouteArr.contains(navBackStackEntry?.destination?.route)) {
////        navController.navigate("home")
//        return
//    }
//}



