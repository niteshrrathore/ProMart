package com.example.promart.data.remote.network

import com.example.promart.domain.model.ProductList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts() : Response<ProductList>

}