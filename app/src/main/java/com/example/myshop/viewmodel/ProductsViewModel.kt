package com.example.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.models.Product
import com.example.myshop.repository.ProductRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ProductsViewModel: ViewModel() {
    val productRepository = ProductRepository()
    var productsLiveData = MutableLiveData<List<Product>>()
    var errorLiveData = MutableLiveData<String>()

    fun fetchProducts(){
        viewModelScope.launch {
            val reponse = productRepository.getProducts()
            if(reponse.isSuccessful){
                productsLiveData.postValue(reponse.body()?.products)
            }
            else{
                errorLiveData.postValue(reponse.errorBody()?.toString())
            }

        }

    }

}







