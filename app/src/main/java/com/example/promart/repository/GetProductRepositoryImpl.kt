package com.example.promart.repository

import com.example.promart.model.Product
import com.example.promart.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class GetProductRepositoryImpl @Inject constructor(private val apiService: ApiService) : GetProductRepository {

    override suspend fun getProducts(): Response<Product> {
        return apiService.getProducts()
    }
}