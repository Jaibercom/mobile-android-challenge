package com.test.amaro.amarotest.api

import com.test.amaro.amarotest.model.Product
import com.test.amaro.amarotest.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("59b6a65a0f0000e90471257d")
    fun requestProducts() : Call<Products>

}