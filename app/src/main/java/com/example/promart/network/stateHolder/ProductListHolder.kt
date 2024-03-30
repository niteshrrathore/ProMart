package com.example.promart.network.stateHolder

import com.example.promart.model.Product

data class ProductListHolder(
    val isLoading:Boolean = false,
    val data : Product? = null,
    val error : String = ""
)
