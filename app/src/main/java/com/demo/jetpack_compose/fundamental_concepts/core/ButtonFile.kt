package com.demo.jetpack_compose.fundamental_concepts.core

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FileButton(){
    val context = LocalContext.current
    // 1. The Box fills the whole screen and centers whatever is inside it
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        // 2. The Column acts as a container to stack the buttons vertically
        Column(
            // Optional: This keeps the buttons centered horizontally within the Column itself
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(text = "Button")
            }
            // 3. A Spacer adds a clean gap between the two buttons
            Spacer(modifier = Modifier.height(16.dp))
            FilledTonalButton(
                onClick = {
                    Toast.makeText(context, "Tonal button Clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(text = "Tonal Button")
            }

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = {
                    Toast.makeText(context, "Outlined button Clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(text = "Outlined Button")
            }

            Spacer(modifier = Modifier.height(16.dp))

            ElevatedButton(
                onClick = {
                    Toast.makeText(context, "Elevated button Clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(text = "Elevated Button")
            }

            Spacer(modifier = Modifier.height(height = 16.dp))
            TextButton(
                onClick = {
                    Toast.makeText(context, "Text button Clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(text = "Text Button")
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun ButtonFilePreview(){
    FileButton()
}
