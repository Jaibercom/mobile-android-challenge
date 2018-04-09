package com.test.amaro.amarotest.Views.ProductsList

import android.content.Context
import android.util.Log
import com.test.amaro.amarotest.model.Product
import com.test.amaro.amarotest.api.ApiService
import com.test.amaro.amarotest.model.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by jaiber on 1/23/18.
 */

class ProductsListInteractor(private val ctx: Context, private val onDataRequestListener: OnDataRequestListener, private val api: ApiService) {

    private var productList: ArrayList<Product>? = null
    //internal var `var`: lateinit? = null


    interface OnDataRequestListener {

        fun onDataReady(productList: List<Product>?)

    }

    companion object {

        private val TAG = "ProductsListInteractor"
    }

    fun requestProducts(){

        Timber.i("on requestProducts")
        api.requestProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>?, response: Response<Products>) {
                Timber.i(response.toString())
                if(response.isSuccessful){
                    productList = response.body()?.products
                    Log.d("TAG", ""+response.toString())

                    if(productList != null)
                    onDataRequestListener.onDataReady(productList)
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Timber.i("errorrrr ${t.message}")
            }
        })
    }

  /*  fun requestProducts() {

        Log.d(TAG, "request")

        val jsonObjReq = JsonObjectRequest(
                Request.Method.GET,
                ConfigURL.INSTANCE.getURL_PRODUCTS(), null,
                Response.Listener { response ->
                    //Log.d(TAG, response.toString());
                    try {
                        val productsJson = response.getJSONArray("products")
                        productList = Product.Companion.fromJson(productsJson)

                        if (productList != null) {
                            for (i in productList!!.indices) {
                                Log.d("*Products", "*Product Name: " + productList!![i].name!!)
                                Log.d("*Products", "*Price: " + productList!![i].actualPrice!!)
                            }
                            onDataRequestListener.onDataReady(productList)
                        } else {
                            Log.d(TAG, "data is null ")
                        }

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener { })
        VolleySingleton.getInstance(ctx).addToRequestQueue(jsonObjReq)
    }
*/


}
