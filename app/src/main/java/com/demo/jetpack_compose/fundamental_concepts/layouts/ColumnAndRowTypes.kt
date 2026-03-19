package com.demo.jetpack_compose.fundamental_concepts.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Lazy Row
@Composable
fun LazyRowExample(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center

    ) {
        Text("LazyRow (prefered for the list)",
        modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
                .background(Color.Gray)
        ) {
            items(count = 100){
                index -> Text(
                text = "Item $index in lazy column",
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Green)
                    .padding(16.dp))
            }
        }
    }
}

// Lazy Column
@Composable
fun LazyColumnExample(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center

    ) {
        Text("LazyRow (prefered for the list)",
            modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn (
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
                .background(Color.Gray)
        ) {
            items(count = 100){
                    index -> Text(
                text = "Item $index in lazy column",
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Magenta)
                    .padding(16.dp))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LazyRowPreview(){
    // LazyRowExample()
    LazyColumnExample()
}