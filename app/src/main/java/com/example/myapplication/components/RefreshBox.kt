package com.example.myapplication.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.pages.RefreshViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun RefreshBox(content: @Composable () -> Unit) {
    val viewModel: RefreshViewModel = viewModel()
    val refreshState by viewModel.refresh.collectAsState()
    val swipeRefresh = rememberSwipeRefreshState(isRefreshing = refreshState)
    SwipeRefresh(state = swipeRefresh, onRefresh = {
        viewModel.startRefresh()
    }, indicator = { state, trigger ->
        // 自定义进度指示器颜色
        SwipeRefreshIndicator(
            state = state,
            refreshTriggerDistance = trigger,
            backgroundColor = MaterialTheme.colorScheme.background, // 进度指示器背景色
            contentColor = MaterialTheme.colorScheme.primary // 进度指示器内容颜色
        )

    }) {
        content()
    }
}