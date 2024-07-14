package com.example.myapplication.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.OverscrollConfiguration
import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.components.NavBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerDefaults
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainPage(navController: NavHostController, sysStatusBarHeight: Dp) {
    val pagerState = rememberPagerState(0)
    val coroutineScope = rememberCoroutineScope()
    CompositionLocalProvider(
        LocalOverscrollConfiguration provides OverscrollConfiguration()
    ) {
        Surface(
            Modifier
                .padding(top = sysStatusBarHeight)
        ) {
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
                        .height(70.dp),
                    tonalElevation = 0.dp,
                    contentPadding = PaddingValues(0.dp)
                )
            }) { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(bottom = innerPadding.calculateBottomPadding())
                ) {
                    HorizontalPager(
                        count = 2,
                        state = pagerState,
                        userScrollEnabled = false
                    ) { pageIndex ->
                        when (pageIndex) {
                            0 -> Home(navController)
                            1 -> My(navController)
                        }
                    }
                }
            }
        }
    }
}

/**
 * 控制滑动切换阈值
 */
val minFlingDistanceDp = 10.dp

@OptIn(ExperimentalPagerApi::class, dev.chrisbanes.snapper.ExperimentalSnapperApi::class)
@Composable
fun flingBehavior(pagerState: PagerState, noOfPages: Int): FlingBehavior {
    var currentPageIndex = remember { pagerState.currentPage }
    return PagerDefaults.flingBehavior(
        state = pagerState,
        snapIndex = { layoutInfo, _, _ ->
            val distanceToStartSnap = layoutInfo.distanceToIndexSnap(currentPageIndex)
            currentPageIndex = when {
                distanceToStartSnap < -(minFlingDistanceDp.value) -> {
                    (currentPageIndex + 1).coerceAtMost(noOfPages - 1)
                }

                distanceToStartSnap > minFlingDistanceDp.value -> {
                    (currentPageIndex - 1).coerceAtLeast(0)
                }

                else -> {
                    currentPageIndex
                }
            }
            currentPageIndex
        }
    )
}