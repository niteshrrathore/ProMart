package com.example.promart.presentation.stateHolder

import com.example.promart.domain.model.ProductList


sealed class ApiState {
    class Success(val data: List<ProductList>) : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    object Loading: ApiState()
    object Empty: ApiState()
}