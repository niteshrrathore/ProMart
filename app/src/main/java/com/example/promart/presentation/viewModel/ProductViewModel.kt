package com.example.promart.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.promart.core.common.Resource
import com.example.promart.presentation.stateHolder.ProductListHolder
import com.example.promart.domain.useCases.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProductUseCase: GetProductUseCase): ViewModel() {

    private val _productListStateHolder = mutableStateOf(ProductListHolder())
    val productListStateHolder : State<ProductListHolder> = _productListStateHolder

    init {
        getAllProducts()
    }

    private fun getAllProducts() = viewModelScope.launch {
        getProductUseCase().onEach {
            when(it){
                is Resource.Loading -> {
                    _productListStateHolder.value = ProductListHolder(isLoading = true)
                }
                is Resource.Success -> {
                    _productListStateHolder.value = ProductListHolder(data = it.data)
                }
                is Resource.Error -> {
                    _productListStateHolder.value = ProductListHolder(error= it.message.toString())
                }

            }
        }.launchIn(viewModelScope)
    }

    /*var productListResponse:List<Item> by mutableStateOf(listOf())
    var errorMessage = MutableLiveData<String>()
    private var job: Job? = null
    val loading = MutableLiveData<Boolean>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getProductList() {
        val retrofitService = ApiService.getInstance()
        val mainRepository = MainRepository(retrofitService)

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            withContext(Dispatchers.Main) {
                try {
                    val productList = mainRepository.getAllProducts()
                    productListResponse = productList.products
                    loading.value = false
                } catch (e: Exception) {
                    onError("Error : ${e.message.toString()} ")
                    errorMessage.value = e.message.toString()
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }*/
}