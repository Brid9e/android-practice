package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.components.NavBar
import com.example.myapplication.route.NavHostBox
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyApplicationTheme {
//            FullScreenBackground("https://c-ssl.duitang.com/uploads/blog/202208/12/20220812140636_b4f94.png")
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
                BackHandle(navController)
                Column(Modifier.padding(top = sysStatusBarHeight)) {
                    Scaffold(bottomBar = {
                        BottomAppBar(
                            content = { NavBar(navController) },
                            modifier = Modifier
                                .height(90.dp),
                            tonalElevation = 0.dp,
                        )
                    }) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .padding(bottom = innerPadding.calculateBottomPadding())
                        ) {
                            NavHostBox(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FullScreenBackground(backgroundImageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .clip(shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)),
        contentAlignment = Alignment.TopCenter,
    ) {
        val painter = rememberAsyncImagePainter(model = backgroundImageUrl)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        // 在这里添加你的其他布局内容，会显示在背景图之上
    }
}

// 上次按返回键的时间戳
var lastBackPressedTime = 0L

@Composable
fun BackHandle(navController: NavHostController) {
    val context = LocalContext.current
    val view = LocalView.current
    val keyboardController = LocalSoftwareKeyboardController.current

    // 使用DisposableEffect监听硬件返回键
    DisposableEffect(Unit) {
        val listener = View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                if (navController.currentDestination?.id == navController.graph.startDestinationId) {
                    // 处理主页面或根页面的返回键逻辑
                    if (!doubleBackToExitPressedOnce(context)) {
                        return@OnKeyListener true
                    }
                } else {
                    navController.navigateUp()
                    return@OnKeyListener true
                }
            }
            false
        }
        view.setOnKeyListener(listener)
        onDispose {
            view.setOnKeyListener(null)
        }
    }
}

fun doubleBackToExitPressedOnce(context: Context): Boolean {
    var result = false
    val currentTimestamp = System.currentTimeMillis()

    if (currentTimestamp - lastBackPressedTime > 2000) {
        lastBackPressedTime = currentTimestamp
        showToast(context, "再按一次退出APP")
    } else {
        result = true
    }

    return result
}

// 显示Toast消息的辅助函数
fun showToast(context: Context, message: String) {
    // 在Compose中直接使用Toast可能不直观，但可以通过Context来实现
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}




