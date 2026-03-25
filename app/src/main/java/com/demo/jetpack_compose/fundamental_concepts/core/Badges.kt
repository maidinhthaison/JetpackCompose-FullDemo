package com.demo.jetpack_compose.fundamental_concepts.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.jetpack_compose.ui.theme.MyApplicationTheme

@Composable
fun BadgeInteractiveExample(){
    var itemCount by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        BadgedBox(
            badge = {
                if(itemCount > 0){
                    Badge(containerColor = Color.Red, contentColor = Color.White){
                        Text(text = itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Add"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { itemCount++ }) {
            Text(text = "Add Item")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BadgeInteractiveExamplePreview(){
    MyApplicationTheme() {
        BadgeInteractiveExample()
    }
}