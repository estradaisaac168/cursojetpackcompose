package com.example.cursojetpackcompose.section19.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cursojetpackcompose.section19.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(
    viewModel : ProductViewModel = viewModel()
){
    val productList = viewModel.productList

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Ejemplo de ViewModel")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) {
        paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)
        ) {
            Text(
                text = "Lista de productos",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp,
                fontWeight = MaterialTheme.typography.titleMedium.fontWeight
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn{
                items(productList){ product ->

                    Card(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    ){
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Nombre: ${product.name}",
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = "Precio: ${product.price}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                }
            }

        }
    }
}
