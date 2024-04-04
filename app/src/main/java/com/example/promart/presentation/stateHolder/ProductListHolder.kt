package com.example.promart.presentation.stateHolder

import com.example.promart.domain.model.ProductList

data class ProductListHolder(
    val isLoading:Boolean = false,
    val data : ProductList? = null,
    val error : String = ""
)
