package com.example.promart.domain.useCases

import com.example.promart.core.common.Resource
import com.example.promart.domain.model.ProductList
import com.example.promart.domain.repository.GetProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val getProductRepository: GetProductRepository) {
    operator fun invoke(): Flow<Resource<ProductList>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = getProductRepository.getProducts().body()))
        } catch (e : Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}