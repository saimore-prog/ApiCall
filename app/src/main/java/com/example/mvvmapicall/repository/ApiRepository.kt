package com.example.mvvmapicall.repository

import kotlinx.coroutines.delay

class ApiRepository {

    //Fake the api call
    suspend fun fetchData(): ApiResponse{
        delay(2000)
        return if (System.currentTimeMillis() % 2 == 0L){
            ApiResponse(success = true, message = "Data Success", data = listOf("Item1", "Item2", "Item3"))
        } else {
            ApiResponse(success = false, message = "Data Fail")
        }
    }

}

data class ApiResponse(
    val success: Boolean,
    val message: String,
    val data: Any? = null
)

