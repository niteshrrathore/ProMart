package com.example.promart.domain.model

data class Product(val id: Int, val title: String, val description: String, val price: Int,
                   val brand: String, val category: String, val thumbnail: String)