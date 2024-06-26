package com.example.promart.products

import com.example.promart.domain.model.ProductList
import com.example.promart.domain.repository.GetProductRepository
import com.example.promart.domain.useCases.GetProductUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.Response

class GetProductUseCaseShould {

    private lateinit var getProductRepository: GetProductRepository
    private lateinit var getProductUseCase: GetProductUseCase
    private val products  = mock <Response<ProductList>>()

    @Before
    fun setUp(){
        getProductRepository = mock()
        getProductUseCase = GetProductUseCase(getProductRepository)

    }

    @Test
    fun returnMovieFromUseCaseInSuccess() = runTest{
        `when`(getProductRepository.getProducts()).thenReturn(
            products
        )
        getProductUseCase.invoke().onEach {
            Assert.assertEquals(products,it.data)
        }
    }

    @Test
    fun returnErrorFromUseCaseInSuccess() = runTest{
        `when`(getProductRepository.getProducts()).thenThrow(
            RuntimeException("Something Went Wrong")
        )
        getProductUseCase.invoke().onEach {
            Assert.assertEquals("Something Went Wrong",it.message)
        }
    }

}