package com.example.promart.network

import com.example.promart.model.Product

sealed class ApiState {
    class Success(val data: List<Product>) : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    object Loading:ApiState()
    object Empty: ApiState()
}