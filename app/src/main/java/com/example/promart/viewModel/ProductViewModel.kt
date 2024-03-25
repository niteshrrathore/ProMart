package com.example.promart.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.promart.model.Product
import com.example.promart.network.ApiState
import com.example.promart.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    val products: StateFlow<Product>
        get() = mainRepository.products

    init {
        viewModelScope.launch {
            mainRepository.getAllProducts()
        }
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