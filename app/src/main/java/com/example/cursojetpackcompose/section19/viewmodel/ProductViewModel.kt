package com.example.cursojetpackcompose.section19.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cursojetpackcompose.section19.model.Product

class ProductViewModel : ViewModel() {

    //Definir una variable de estado que tendra la lista de productos
    var productList by mutableStateOf<List<Product>>(emptyList()) //mutableStateOf permite crear un estado que sea observable
        private set // => Solamente la clase de viewmodel puede modificar esta variable.

    init { //init es un bloque de inicializacion que se ejecuta cuando se crea una instancia de la clase viewmodel
        getProducts()
    }

    private fun getProducts(){ //Los datos deben de venir de un repositorio, por ahorita de manera de ejemplo
        productList = listOf(
            Product(1, "Producto 1", 10.0),
            Product(2, "Producto 2", 20.0),
            Product(3, "Producto 3", 30.0),
            Product(4, "Producto 4", 40.0),
            Product(5, "Producto 5", 50.0),
            Product(6, "Producto 6", 60.0),
            Product(7, "Producto 7", 70.0),
            Product(8, "Producto 8", 80.0),
            Product(9, "Producto 9", 90.0),
            Product(10, "Producto 10", 100.0),
        )
    }
}
