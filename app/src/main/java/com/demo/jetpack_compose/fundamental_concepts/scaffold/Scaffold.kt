package com.demo.jetpack_compose.fundamental_concepts.scaffold

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var presses by remember{ mutableStateOf(0) }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.primaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.surface
                ),
                title = { Text("Scaffold Example") })
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ){
                Text("Bottom bar",
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                presses++
                Toast.makeText(context, "FAB Clicked", Toast.LENGTH_SHORT).show()
            }){
                Text("I've been clicked $presses times")
            }
        }
    ) {
        innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.primary)
            ){
                Text("This is scaffold content")
            }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScaffoldExamplePreview(){
    ScaffoldExample()
}