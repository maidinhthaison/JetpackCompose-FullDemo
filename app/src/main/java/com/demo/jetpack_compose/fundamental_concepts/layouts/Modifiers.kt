package com.demo.jetpack_compose.fundamental_concepts.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp

// Modifiers are available in all the composables like text, button, image, column etc.
@Composable
fun ModifierExample(){
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(
                color = Color.Green,
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            LoremIpsum(words = 10).values.joinToString(" "),
            modifier = Modifier.background(Color.Yellow)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ModifierPreview(){
    ModifierExample()
}