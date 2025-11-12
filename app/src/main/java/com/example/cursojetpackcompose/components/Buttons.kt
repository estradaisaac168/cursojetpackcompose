package com.example.cursojetpackcompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(){
    Button(
        onClick = { /*TODO*/ },
        colors= ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite"
        )

        Text("Like")
    }

    Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))

    OutlinedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.shadow(4.dp, RoundedCornerShape(10.dp))
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )

        Text("Like")
    }


    TextButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text("Ir al enlace")
    }

}
