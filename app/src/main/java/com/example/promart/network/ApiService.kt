package com.example.promart.network

import com.example.promart.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts() : Response<Product>

}