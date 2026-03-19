package com.demo.jetpack_compose.fundamental_concepts.inputchips

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputChipExample() {
    // State to track if the chip is selected
    var isSelected by remember { mutableStateOf(false) }
    // State to track if the chip is visible (not dismissed)
    var isVisible by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isVisible) {
            InputChip(
                selected = isSelected,
                onClick = {
                    // Toggle selection behavior
                    isSelected = !isSelected
                    println("Chip selected: $isSelected")
                },
                label = {
                    Text(text = "Input Chip")
                },
                avatar = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "Person",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close",
                        modifier = Modifier
                            .size(InputChipDefaults.AvatarSize)
                            .clickable {
                                // Dismissal behavior: trigger event and hide chip
                                isVisible = false
                                println("Chip dismissed")
                            }
                    )
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun InputChipExamplePreview() {
    InputChipExample()
}
