package com.example.promart.products

import com.example.promart.MainCoroutineRule
import com.example.promart.model.Product
import com.example.promart.network.common.Resource
import com.example.promart.network.useCases.GetProductUseCase
import com.example.promart.viewModel.ProductViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class ProductViewModelShould {

    @get:Rule
    val mainCoroutineRule =  MainCoroutineRule()

    private val getProductUseCase: GetProductUseCase = mock()
    private lateinit var productViewModel : ProductViewModel
    private val movieList : Product? = mock()

    @Before
    fun setup(){
        productViewModel =  ProductViewModel(getProductUseCase)
    }

    @Test
    fun validateUserWillSeeProgressBarInitially() = runTest {
        `when`(getProductUseCase.invoke()).thenReturn(
            flow {
                emit(Resource.Loading())
            }
        )
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(true,productViewModel.productListStateHolder.value.isLoading)
    }

    @Test
    fun validateSuccessStateIsStoredInMovieList() = runTest {
        `when`(getProductUseCase.invoke()).thenReturn(
            flow {
                emit(Resource.Success(movieList))
            }
        )
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(movieList,productViewModel.productListStateHolder.value.data)
    }

    @Test
    fun throwErrorInErrorCase() = runTest {
        `when`(getProductUseCase.invoke()).thenReturn(
            flow {
                emit(Resource.Error("Something Went Wrong"))
            }
        )
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals("Something Went Wrong",productViewModel.productListStateHolder.value.error)
    }

}