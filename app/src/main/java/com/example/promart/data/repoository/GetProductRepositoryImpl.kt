package com.example.promart.data.repoository

import com.example.promart.data.remote.network.ApiService
import com.example.promart.domain.model.ProductList
import com.example.promart.domain.repository.GetProductRepository
import retrofit2.Response
import javax.inject.Inject

class GetProductRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    GetProductRepository {

    override suspend fun getProducts(): Response<ProductList> {
        return apiService.getProducts()
    }
}