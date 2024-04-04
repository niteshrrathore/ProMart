package com.example.promart.domain.repository

import com.example.promart.domain.model.ProductList
import retrofit2.Response

interface GetProductRepository {
    suspend fun getProducts() : Response<ProductList>

}