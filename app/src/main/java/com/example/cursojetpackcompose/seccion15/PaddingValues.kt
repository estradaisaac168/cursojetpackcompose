package com.example.cursojetpackcompose.seccion15

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaddingValues(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My App")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(paddingValues)
                .padding(48.dp)

        ) {
            Text(text = "Sin pading", color = Color.White)
            Text(text = "Este texto queda debajo del appbar", color = Color.White)

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(paddingValues)
                .padding(48.dp)
        ) {
            Text(text = "Con  paddingValues", color = Color.White)
            Text(text = "Se logra apreciar bien debajo del appbar", color = Color.White)
        }
    }
}