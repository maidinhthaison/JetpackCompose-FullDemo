package com.demo.jetpack_compose.fundamental_concepts.dialog

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.demo.jetpack_compose.R
import com.demo.jetpack_compose.ui.theme.MyApplicationTheme


@Composable
fun AlertDialogExample() {
    // 1. Create a variable to store the state of the dialog
    var showDialog by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Green)
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // 2. Button to trigger the dialog
            Button(onClick = { showDialog = true }) {
                Text("Show Dialog")
            }
            // 3. Conditionally show the dialog
            if (showDialog) {
                DialogWithImage(onDismiss = {
                    showDialog = false
                })
            }
        }

    }
}

@Composable
fun DialogWithImage(onDismiss: () -> Unit){
    val context = LocalContext.current
    Dialog(
        onDismissRequest = {

        }
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
                .height(350.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.news),
                contentDescription = "This is dialog image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp).fillMaxWidth()
            )
            Text(
                text = "This is the dialog",
                modifier = Modifier.padding(16.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedButton(
                    onClick = {
                        Toast.makeText(context,"You can do something here",
                            Toast.LENGTH_SHORT).show()
                        onDismiss() // Close the dialog
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Confirm")
                }

                OutlinedButton(
                    onClick = {
                        Toast.makeText(context,"Cancel", Toast.LENGTH_SHORT).show()
                        onDismiss() // Close the dialog
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Cancel")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DialogExamplePreview(){
    MyApplicationTheme {
        AlertDialogExample()
    }
}