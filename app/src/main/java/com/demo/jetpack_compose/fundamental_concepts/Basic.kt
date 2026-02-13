package com.demo.jetpack_compose.fundamental_concepts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.jetpack_compose.ui.theme.MyApplicationTheme

@Composable
fun Greeting(){
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello Jetpack Compose",
            // Pull the primary color from your Theme.kt/Color.kt
            color = MaterialTheme.colorScheme.primary,
            // Pull the titleLarge style from your Theme.kt/Type.kt
            style = MaterialTheme.typography.titleLarge
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    MyApplicationTheme {
        Greeting()
    }
}