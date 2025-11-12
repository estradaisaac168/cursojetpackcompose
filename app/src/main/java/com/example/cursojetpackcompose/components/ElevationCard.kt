package com.example.cursojetpackcompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyElevationCard(){
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 15.dp
        )
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(text = "Card Title",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                style = MaterialTheme.typography.bodySmall
            )

        }

    }
}