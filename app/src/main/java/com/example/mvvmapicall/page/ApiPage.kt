package com.example.mvvmapicall.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvmapicall.repository.ApiResponse


@Composable
fun ApiPage(apiResponse: ApiResponse?, onFetchData: () -> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            apiResponse == null -> {
                CircularProgressIndicator()
            }
            apiResponse.success -> {
                Text(text = "Success: ${apiResponse.message}")
                apiResponse.data?.let {
                    Text(text = "Data: $it")
                }
            }
            else ->{
                Text(text = "Error: ${apiResponse.message}",
                color = MaterialTheme.colorScheme.error
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onFetchData}) {
            Text(text = "Fetch Data")
        }
    }
}


//Loading
@Preview(showBackground = true, name = "Loading Data")
@Composable
fun PreviewLoadingData(){
    ApiPage(apiResponse = null) {

    }
}

//Success
@Preview(showBackground = true, name = "Success")
@Composable
fun PreviewSuccessData(){
    val mockResponse = ApiResponse(
        success = true, message = "Data Success", data = listOf("Item1", "Item2", "Item3")
    )
    ApiPage(apiResponse = mockResponse) {

    }
}

//Failure
@Preview(showBackground = true, name = "Failure")
@Composable
fun PreviewFailureData(){
    val mockResponse = ApiResponse(
        success = false, message = "Data Fail"
    )
    ApiPage(apiResponse = mockResponse) {

    }
}
