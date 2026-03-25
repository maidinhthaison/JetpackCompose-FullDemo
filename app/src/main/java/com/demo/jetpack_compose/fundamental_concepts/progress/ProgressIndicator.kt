package com.demo.jetpack_compose.fundamental_concepts.progress

import android.transition.CircularPropagation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.jetpack_compose.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

@Composable
fun CircularIndicator(){
    var loading by remember { mutableStateOf(false) }
    //Simulate loading delay and reset loading to false
    LaunchedEffect(loading) {
        if (loading){
            delay(3000) // show loading 3 seconds
            loading = false
        }
    }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Button(onClick = { loading = true }) {
            Text(text = "Start Loading")
        }
        Spacer(modifier = Modifier.height(15.dp))
        if (loading){
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProgressIndicatorPreview(){
    MyApplicationTheme() {
        CircularIndicator()
    }
}