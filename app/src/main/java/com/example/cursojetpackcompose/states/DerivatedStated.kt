package com.example.cursojetpackcompose.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CounterScreen(){

    var counter by remember { mutableIntStateOf(0) }

    val isPair by remember { derivedStateOf { counter % 2 == 0 } }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Counter: $counter"
        )
        Text(
            text = if (isPair) "Even" else "Odd"
        )

        Button(
            onClick = { counter++ }
        ) {
            Text(text = "Increment")
        }
    }

}


@Composable
fun MyDerivedState(){
    var text by remember { mutableStateOf("") }

    val textColor by remember { derivedStateOf { if (text.length > 5) Color.Red else Color.Blue } }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Longitud del texto: ${text.length}",
            color = textColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Enter text") }
        )


    }
}