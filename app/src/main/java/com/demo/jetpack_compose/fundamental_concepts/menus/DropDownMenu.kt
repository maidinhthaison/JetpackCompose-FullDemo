package com.demo.jetpack_compose.fundamental_concepts.menus

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.jetpack_compose.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DropDownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "This is 3 dots")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                DropdownMenuItem(
                    text = {
                        Text("Profile")
                    },
                    leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = "Profile") },
                    onClick = {
                        Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show()
                        // Smooth dismissal: delay slightly to allow ripple to finish
                        scope.launch {
                            delay(100)
                            expanded = false
                        }
                    }
                )
                HorizontalDivider()
                DropdownMenuItem(
                    text = {
                        Text("Setting")
                    },
                    trailingIcon = { Icon(Icons.Outlined.Settings, contentDescription = "Settings") },
                    onClick = {
                        Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
                        scope.launch {
                            delay(100)
                            expanded = false
                        }
                    }
                )
                HorizontalDivider()
                DropdownMenuItem(
                    text = { Text("About") },
                    trailingIcon = { Icon(Icons.Outlined.AccountBox, contentDescription = "Account") },
                    onClick = {
                        Toast.makeText(context, "About", Toast.LENGTH_SHORT).show()
                        scope.launch {
                            delay(100)
                            expanded = false
                        }
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DropDownMenuExamplePreview() {
    MyApplicationTheme {
        DropDownMenuExample()
    }
}
