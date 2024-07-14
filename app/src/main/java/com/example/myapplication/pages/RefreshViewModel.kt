package com.example.myapplication.pages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RefreshViewModel : ViewModel() {
    private var _refresh = MutableStateFlow(false)
    val refresh = _refresh
    fun startRefresh() {
        viewModelScope.launch {
            _refresh.value = true
            delay(1000)
            _refresh.value = false
        }
    }

}