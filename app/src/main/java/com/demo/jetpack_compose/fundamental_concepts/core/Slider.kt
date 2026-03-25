package com.demo.jetpack_compose.fundamental_concepts.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.jetpack_compose.ui.theme.MyApplicationTheme

@Composable
fun SliderExample(){
    var sliderPosition by remember { mutableStateOf(0f) }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            },
            modifier = Modifier.padding(horizontal = 32.dp),
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            steps = 10,
            valueRange = 0f..50f,
        )
        Text(text = String.format("%.1f", sliderPosition), style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showSystemUi = true)
@Composable
fun SliderPreview(){
    MyApplicationTheme() {
        SliderExample()
    }
}
