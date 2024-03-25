package com.example.promart.model

data class Product(
    val products: List<Item>
)
data class Item(val id: Int, val title: String, val description: String, val price: Int,
                val brand: String, val category: String, val thumbnail: String)