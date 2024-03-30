package com.example.promart.products

import com.example.promart.MainCoroutineRule
import com.example.promart.model.Product
import com.example.promart.network.ApiService
import com.example.promart.repository.GetProductRepository
import com.example.promart.repository.GetProductRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.Response

class GetProductRepositoryShould {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()
    private lateinit var getProductRepository: GetProductRepository
    private lateinit var apiService: ApiService
    private val products  = mock <Response<Product>>()

    @Before
    fun setUp(){
        apiService = mock()
        getProductRepository = GetProductRepositoryImpl(apiService)
    }

    @Test
    fun returnSuccessWhenGetDataFromBackend() = runTest{
        `when`(apiService.getProducts()).thenReturn(
            products
        )
        val result = getProductRepository.getProducts()
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(products,result)
    }
}