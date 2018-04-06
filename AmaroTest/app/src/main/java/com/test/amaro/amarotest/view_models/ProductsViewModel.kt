package com.test.amaro.amarotest.view_models

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.test.amaro.amarotest.Model.Product

class ProductsViewModel: ViewModel() {

    val products = MutableLiveData<List<Product>>()

    fun loadProducts(){

        products.value
    }

}