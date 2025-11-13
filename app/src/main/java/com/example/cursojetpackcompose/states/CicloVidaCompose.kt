package com.example.cursojetpackcompose.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CounterLifeCycle(){

    var count by remember { mutableIntStateOf(0) }

    /*
    * Se ejecuta por primera vez cuando este composable se muestre por primera vez en pantalla
    * Unit -> Efecto que solo se ejecute una vez*/
    LaunchedEffect(Unit) {
        println("Se ejecuta una vez, La pantalla se esta componiendo")
    }

    println("La pantalla se esta recomponiendo")


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Count: $count",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count++ }) {
            Text(text = "Incrementar")
        }

    }
}