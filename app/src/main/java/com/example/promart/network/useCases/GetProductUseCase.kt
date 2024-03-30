package com.example.promart.network.useCases

import com.example.promart.model.Product
import com.example.promart.network.common.Resource
import com.example.promart.repository.GetProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val getProductRepository: GetProductRepository) {
    operator fun invoke(): Flow<Resource<Product>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = getProductRepository.getProducts().body()))
        } catch (e : Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}