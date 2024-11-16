package com.example.mvvmapicall.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapicall.repository.ApiRepository
import com.example.mvvmapicall.repository.ApiResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiViewModel(private val repository: ApiRepository): ViewModel() {
    private val _apiState = MutableStateFlow<ApiResponse?>(null)
    val apiState: StateFlow<ApiResponse?> = _apiState

    fun fetchData(){
        viewModelScope.launch {
            _apiState.value = null //
            val response = repository.fetchData()
            _apiState.value = response
        }
    }
}