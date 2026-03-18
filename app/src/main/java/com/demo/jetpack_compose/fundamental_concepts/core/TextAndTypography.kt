package com.demo.jetpack_compose.fundamental_concepts.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SimpleText(){
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello Jetpack Compose",
            color = Color.Blue,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(color = Color.Black, blurRadius = 20f)
            )
        )
    }
}

@Composable
fun ColorFullText(){
    val rainbowColors = listOf(
        Color.Red,
        Color.Green,
        Color.Yellow,
        Color.Green,
        Color.Cyan,
        Color.Magenta,
        Color.LightGray
    )
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ){
        Text(
            text = buildAnnotatedString {
                append("Do not allow people to dim your shine \n")
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ){
                    append("because they are blind")
                    append("\n1 2 3 4")
                }
                append("\n Ha ha ha")
            }
        )
    }
}

@Composable
fun ScrollableText(){
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ){
        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                    " when an unknown printer took a galley of type and scrambled it to make a \n" +
                    "type specimen book. It has survived not only five centuries, but also the \n" +
                    "leap into electronic typesetting, remaining essentially unchanged. \n" +
                    "It was popularised in the 1960s with the release of Letraset sheets containing\n" +
                    "Lorem Ipsum passages, and more recently with desktop publishing software\n" +
                    "like Aldus PageMaker including versions of Lorem Ipsum",
            color = Color.Blue,
            fontSize = 20.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ExampleTextPreview() {
//    SimpleText()
    // ColorFullText()
    ScrollableText()
}