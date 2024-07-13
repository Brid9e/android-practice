package com.example.myapplication.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.Autofill
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.myapplication.components.ContentBox
import com.example.myapplication.components.Panel
import com.example.myapplication.components.SearchBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Home(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    val tabs = listOf(
        "CS2",
        "DOTA2",
        "ZZZ",
        "GENSHEN",
        "VALORANT",
        "CS2",
        "DOTA2",
        "ZZZ",
        "GENSHEN",
        "VALORANT"
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { tabs.size })
    Column {
        SearchBar()
        TabRow(tabs, pagerState, coroutineScope)
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill
        ) { page ->
            ContentBox {
                repeat(10) {
                    Panel(page)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabRow(tabs: List<String>, pagerState: PagerState, coroutineScope: CoroutineScope) {
    PrimaryScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = MaterialTheme.colorScheme.onBackground,
        edgePadding = 0.dp,
        modifier = Modifier.padding(bottom = 8.dp),
        divider = { },
        indicator = {
            TabRowDefaults.PrimaryIndicator(
                height = 8.dp,
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier.tabIndicatorOffset(pagerState.currentPage),
            )
        }
    ) {
        tabs.forEachIndexed { index, s ->
            Tab(selected = pagerState.currentPage == index, onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }, text = { Text(text = s, fontWeight = FontWeight(600)) })
        }

    }
}

