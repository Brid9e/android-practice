package com.example.myapplication.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.components.RowGroup
import com.example.myapplication.components.TitleContent
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeHot() {
    Column {
        TitleContent(title = "最新", useDefaultPadding = false) {
            RowGroup() {

            }
        }
        TitleContent(title = "今日排行榜", useDefaultPadding = false) {
            RowGroup(width = 200.dp, height = 200.dp) { item ->
//                Text(text = "$item")
            }
        }

        TitleContent(title = "推荐", useDefaultPadding = false) {
            RowGroup(width = 250.dp, height = 400.dp) { item ->
//                Text(text = "$item")
            }
        }
    }
}