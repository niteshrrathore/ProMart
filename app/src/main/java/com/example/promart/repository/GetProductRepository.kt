package com.example.promart.repository

import com.example.promart.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface GetProductRepository {
    suspend fun getProducts() : Response<Product>

}