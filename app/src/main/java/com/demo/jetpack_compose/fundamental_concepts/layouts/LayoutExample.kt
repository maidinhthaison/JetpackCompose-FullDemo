package com.demo.jetpack_compose.fundamental_concepts.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


// 1. Column, it allows you to place its children in a vertical sequence.
@Composable
fun ColumnExample(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(15.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
    ) {
        Text(text = LoremIpsum(words = 2).values.joinToString(" "))
        Text(text = LoremIpsum(words = 3).values.joinToString(" "))
        Text(text = LoremIpsum(words = 4).values.joinToString(" "))
        Text(text = LoremIpsum(words = 5).values.joinToString(" "))
        Text(text = LoremIpsum(words = 6).values.joinToString(" "))
    }
}

@Composable
fun RowExample(){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(50.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..5) {
            Text(text = "Text $i")
        }
    }
}

@Composable
fun BoxExample(){
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.Gray)
            .padding(50.dp)
    ){
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Inside Box")
        }
    }
}
// ConstraintLayout : Use Only When Needed and UI is Complex
@Composable
fun ConstraintLayoutExample(){
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.Green)
            .padding(10.dp)
    ){
        Column {
            ConstraintLayout(
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color.Gray)
            ) {
                val (text1, text2, text3) = createRefs()
                Text(
                    text = "Bottom left",
                    modifier = Modifier.constrainAs(text1) {
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                        start.linkTo(parent.start, margin = 8.dp)
                    },
                    color = Color.Blue
                )
                Text(
                    text = "Center left",
                    modifier = Modifier.constrainAs(text2) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    },
                    color = Color.Magenta
                )
                Text("Top right",
                    modifier = Modifier.constrainAs(text3) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end, margin = 8.dp)
                    },
                    color = Color.Yellow
                )
            }
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun LayoutReview(){
    ConstraintLayoutExample()
}