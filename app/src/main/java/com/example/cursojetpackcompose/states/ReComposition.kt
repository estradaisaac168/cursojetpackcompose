package com.example.cursojetpackcompose.states

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SegmentedButtonDefaults.colors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Recomposition(){
    var isClicked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
    ) {
       Text(
           text = if (isClicked) "Clicked" else "Not Clicked",
           fontWeight = FontWeight.Bold,
           fontSize = 18.sp
       )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {isClicked = !isClicked }, // Toggle the state
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isClicked) Color.Green else Color.Red
            )
        ) {
            Text(
                text = if (isClicked) "Revert" else "Press",
            )
        }
    }
}