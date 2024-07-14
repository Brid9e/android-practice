package com.example.myapplication.pages

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.myapplication.components.ContentBox
import com.example.myapplication.components.Panel
import com.example.myapplication.components.RefreshBox
import com.example.myapplication.components.SearchBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.min

@Composable
fun Home(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    val tabs = listOf(
        "热门",
        "发现",
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { tabs.size })
    Column {
        SearchBar()
        TabRow(tabs, pagerState, coroutineScope)
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill
        ) { page ->
            RefreshBox {
                ContentBox {
                    when (page) {
                        0 -> HomeHot()
                        1 -> HomeHot()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabRow(tabs: List<String>, pagerState: PagerState, coroutineScope: CoroutineScope) {
    PrimaryTabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = MaterialTheme.colorScheme.onBackground,
        divider = { },
        modifier = Modifier.padding(horizontal = 16.dp),
        indicator = {
            TabRowDefaults.PrimaryIndicator(
                width = 20.dp,
                height = 5.dp,
                modifier = Modifier
                    .tabIndicatorOffset(pagerState.currentPage),
            )
        }
    ) {
        tabs.forEachIndexed { index, s ->
            val selected = pagerState.currentPage == index
            Tab(
                selected,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                modifier = Modifier.padding(bottom = 8.dp).height(40.dp),
                text = {
                    val fontSize by animateFloatAsState(
                        targetValue = if (selected) 22f else 14f,
                        label = ""
                    )
                    Text(
                        text = s,
                        fontSize = fontSize.sp,
                        fontWeight = FontWeight(600),
                    )
                },
            )
        }

    }
}

