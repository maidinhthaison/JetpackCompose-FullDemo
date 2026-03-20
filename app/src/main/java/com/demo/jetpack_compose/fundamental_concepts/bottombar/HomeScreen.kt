package com.demo.jetpack_compose.fundamental_concepts.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This is the Home screen",
            fontSize = 30.sp
        )
        Spacer(Modifier.height(25.dp))
        Button(
            onClick = {
                navController.navigate(BottomBarRoutes.Wishlist) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }

                }
            }
        ) {
            Text("Go to WishlistScreen")
        }
    }
}
