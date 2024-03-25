package com.example.promart.repository

import com.example.promart.model.Product
import com.example.promart.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    private val _product = MutableStateFlow<Product>(Product(emptyList()))
    val products: StateFlow<Product> get() = _product

    suspend fun getAllProducts() {
        val productResponse = apiService.getProducts()
        if (productResponse.isSuccessful && productResponse.body()!=null){
            _product.emit(productResponse.body()!!)
        }
    }

}