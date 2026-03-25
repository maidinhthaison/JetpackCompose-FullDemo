package com.demo.jetpack_compose.fundamental_concepts.core

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.jetpack_compose.ui.theme.MyApplicationTheme

@Composable
fun SwitchExample(){
    var checked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Switch(
                checked = checked,
                onCheckedChange = { checked = it},
                thumbContent = {
                    if (checked) {
                        Icon(imageVector = Icons.Filled.Check, contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize))
                    }else{
                        null
                    }
                }
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                if (checked) "Switch is On" else "Switch is Off",
            )
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun SwitchExamplePreview(){
    MyApplicationTheme() {
        SwitchExample()
    }

}