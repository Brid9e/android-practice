package com.example.myapplication.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.components.ContentBox
import com.example.myapplication.components.SearchBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Home(navController: NavHostController) {
    val pagerState = rememberPagerState(0)
    val coroutineScope = rememberCoroutineScope()
    val tabs = listOf("NEWS", "NEWS", "NEWS", "NEWS", "NEWS", "NEWS", "NEWS", "NEWS", "NEWS")
    Column {
        SearchBar()
        TabRow(tabs, pagerState, coroutineScope)
        HorizontalPager(count = tabs.size, state = pagerState, modifier = Modifier.fillMaxSize()) {
            ContentBox {
                Surface(Modifier.fillMaxSize()) {
                    Text(
                        text = "Page ${it + 1}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabRow(tabs: List<String>, pagerState: PagerState, coroutineScope: CoroutineScope) {
    ScrollableTabRow(selectedTabIndex = pagerState.currentPage, indicator = { tabPositions ->
        SecondaryIndicator(
//
        )
    }) {
        tabs.forEachIndexed { index, s ->
            Tab(selected = pagerState.currentPage == index, onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }, text = { Text(text = s) })
        }

    }
}

