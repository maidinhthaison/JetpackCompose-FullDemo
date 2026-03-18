package com.demo.jetpack_compose.fundamental_concepts.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.jetpack_compose.R

@Composable
fun ImageShow(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        val rainbowColor = remember {
            Brush.sweepGradient(
                listOf(
                    Color.Red,
                    Color.Cyan,
                    Color.Yellow,
                    Color.Green,
                    Color.Blue
                )
            )
        }
        val borderWidth = 10.dp

        Image(
            painter = painterResource(R.drawable.news),
            contentDescription = "News Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp).border(
                BorderStroke(borderWidth, rainbowColor)
            ),
            alignment = Alignment.Center
//            , colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
//                setToSaturation(0f)
//            })
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun ImagePreview(){
    ImageShow()
}