package com.example.myapplication.pages

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.components.NavBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainPage(navController: NavHostController, sysStatusBarHeight: Dp) {
    val pagerState = rememberPagerState(0)
    val coroutineScope = rememberCoroutineScope()
    Surface(Modifier.padding(top = sysStatusBarHeight)) {
        Scaffold(bottomBar = {
            BottomAppBar(
                content = {
                    NavBar(pagerState.currentPage) { index ->
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    }
                },
                modifier = Modifier
                    .height(90.dp),
                tonalElevation = 0.dp,
            )
        }) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(bottom = innerPadding.calculateBottomPadding())
            ) {
                HorizontalPager(count = 2, state = pagerState) { pageIndex ->
                    println("change$pageIndex")
                    when (pageIndex) {
                        0 -> Home(navController)
                        1 -> My(navController)
                    }
                }
            }
        }
    }
}