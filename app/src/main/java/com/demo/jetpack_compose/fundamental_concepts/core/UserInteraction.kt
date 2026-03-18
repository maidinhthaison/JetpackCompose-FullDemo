package com.demo.jetpack_compose.fundamental_concepts.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import java.lang.reflect.AnnotatedElement

@Composable
fun PartiallySelectableText(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        SelectionContainer {
            Text(text = LoremIpsum(words = 5).values.joinToString(" "))
            Text(text = LoremIpsum(words = 10).values.joinToString(separator = " "))
            Text(text = LoremIpsum(words = 15).values.joinToString(separator = " "))
            DisableSelection {
                Text(text = LoremIpsum(words = 20).values.joinToString(separator = " "))
                Text(text = LoremIpsum(words = 30).values.joinToString(separator = " "))
            }
        }
    }
}

@Composable
fun AnnotatedStringWithListenerSample(){
    val uriHandler = LocalUriHandler.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(
            buildAnnotatedString {
                append(text = LoremIpsum(words = 10).values.joinToString(" "))
                val link = LinkAnnotation.Url(
                    url = "https://developer.android.com/develop/ui/compose/documentation",
                    styles = TextLinkStyles(
                        style = SpanStyle(color = Color.Blue)
                    )
                ){
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }
                withLink(link){
                    append(text = " Jetpack Compose")
                }
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSelectable(){
    //PartiallySelectableText()
    AnnotatedStringWithListenerSample()
}