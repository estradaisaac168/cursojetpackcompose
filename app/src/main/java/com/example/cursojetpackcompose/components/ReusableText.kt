package com.example.cursojetpackcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReusableText(
    text: String,
    fontSize: TextUnit = 20.sp,
    fontWeight: FontWeight = FontWeight.Medium,
    fontFamily: FontFamily = FontFamily.SansSerif,
    color: Color = MaterialTheme.colorScheme.primary
){
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        color = color
    )
}

@Composable
fun MyTextview() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(
            state = rememberScrollState(),
            enabled = true
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        ReusableText(
            "Estrada Isaac",
            fontSize = 30.sp
        )

        ReusableText(
            "Developer",
            color = MaterialTheme.colorScheme.secondary
        )

        ReusableText(
            "https://github.com/estradaisaac",
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

