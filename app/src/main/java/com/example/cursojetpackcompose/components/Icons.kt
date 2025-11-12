package com.example.cursojetpackcompose.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyIcon(){
    Icon(
        imageVector = Icons.Default.Email,
        contentDescription = "Email",
        tint = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier.size(60.dp).padding(16.dp)
    )
}
