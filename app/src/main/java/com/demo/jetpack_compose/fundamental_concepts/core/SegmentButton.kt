package com.demo.jetpack_compose.fundamental_concepts.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.MultiChoiceSegmentedButtonRowScope
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.jetpack_compose.ui.theme.MyApplicationTheme

@Composable
fun SegmentButtonExample(){
    val selectionOptions = remember {
        mutableStateListOf(false, false, false)
    }
    val options = listOf("Walk", "Ride", "Drive")

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),
                    checked = selectionOptions[index],
                    onCheckedChange = {
                        selectionOptions[index] != selectionOptions[index]
                    },
                    icon = {
                        SegmentedButtonDefaults.Icon(selectionOptions[index])
                    },
                    label = {
                        when(label){
                            "Walk" -> Icon(Icons.AutoMirrored.Filled.DirectionsWalk,
                                contentDescription = "Walk")
                            "Drive" -> Icon(Icons.Default.DirectionsBus,
                                contentDescription = "Drive")
                            "Ride" -> Icon(Icons.Default.DirectionsCar,
                                contentDescription = "Ride")
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SegmentButtonExamplePreview(){
    MyApplicationTheme {
        SegmentButtonExample()
    }

}