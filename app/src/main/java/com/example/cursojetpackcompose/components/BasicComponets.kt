package com.example.cursojetpackcompose.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyHelpers() {
    HorizontalDivider(
        color = MaterialTheme.colorScheme.primary,
        thickness = 2.dp,
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
    )

    Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
}

@Composable
fun MyProgressIndicators(){
    CircularProgressIndicator(
        color = MaterialTheme.colorScheme.primary,
        strokeWidth = 2.dp,
        modifier = Modifier.size(60.dp).padding(16.dp)
    )

    LinearProgressIndicator(
        color = MaterialTheme.colorScheme.primary,
        trackColor = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
    )
}
