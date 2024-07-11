package com.example.myapplication.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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

//, indicator = { tabPositions ->
//    SecondaryIndicator(
////
//    )
//}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabRow(tabs: List<String>, pagerState: PagerState, coroutineScope: CoroutineScope) {
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = MaterialTheme.colorScheme.onBackground,
        divider = { },
        indicator = { tabPositions ->
            SecondaryIndicator(
                modifier = Modifier
                    .width(10.dp)
                    .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                    .clip(shape = RoundedCornerShape(10.dp)),
                height = 2.dp,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        edgePadding = 0.dp
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

