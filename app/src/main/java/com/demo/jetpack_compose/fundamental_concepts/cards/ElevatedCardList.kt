package com.demo.jetpack_compose.fundamental_concepts.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class CardItem(
    val title: String,
    val description: String
)

@Composable
fun ElevatedCardListItem(item: CardItem) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 1. Image align left vertical
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
            )

            // 2. Two texts (Title and Subtitle)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 8.dp)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // 3. Button align end
            Button(onClick = {
                println("Button Clicked for ${item.title}")
            }) {
                Text("Action")
            }
        }
    }
}

@Composable
fun ElevatedCardList() {
    val items = List(20) { index ->
        CardItem(
            title = "Item Title ${index + 1}",
            description = "Description for item ${index + 1} goes here."
        )
    }

    // Applying systemBarsPadding to the Modifier ensures the LazyColumn
    // itself stays within the safe area and never scrolls behind the system bars.
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(items) { item ->
            ElevatedCardListItem(item = item)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ElevatedCardListPreview() {
    ElevatedCardList()
}
