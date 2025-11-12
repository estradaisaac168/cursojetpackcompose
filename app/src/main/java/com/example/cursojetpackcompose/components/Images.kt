package com.example.cursojetpackcompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cursojetpackcompose.R

@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.fotoperfil),
        contentDescription = "Foto de perfil",
        modifier = Modifier.size(200.dp).clip(CircleShape).border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary,
            shape = CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyCanva(){
    val backgroundColor = MaterialTheme.colorScheme.primary

    Canvas(
        modifier = Modifier.size(300.dp).padding(16.dp)
    ) {
        drawCircle(
            color = backgroundColor,
            radius = size.minDimension/4
        )
    }
}
