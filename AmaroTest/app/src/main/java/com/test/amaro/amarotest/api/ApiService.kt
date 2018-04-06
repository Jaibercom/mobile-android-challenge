package com.test.amaro.amarotest.api

import com.test.amaro.amarotest.Model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("59b6a65a0f0000e90471257d")
    fun requestProducts() : Call<List<Product>>

}