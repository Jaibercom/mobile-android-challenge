package com.test.amaro.amarotest.Views.ProductsList;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.test.amaro.amarotest.Model.Product;
import com.test.amaro.amarotest.WebServices.ConfigURL;
import com.test.amaro.amarotest.WebServices.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by jaiber on 1/23/18.
 */

public class ProductsListInteractor {

    private static final String TAG = "ProductsListInteractor" ;
    private List<Product> productList;
    private Context ctx;
    private OnDataRequestListener onDataRequestListener;

    public interface OnDataRequestListener {

        void onDataReady(List<Product> productList);

    }

    public ProductsListInteractor(Context _ctx, OnDataRequestListener listener){
        ctx = _ctx;
        onDataRequestListener = listener;
    }

    public void requestProducts() {

        Log.d(TAG, "request");

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET,
                ConfigURL.URL_PRODUCTS,
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.d(TAG, response.toString());
                        try {
                            JSONArray productsJson = response.getJSONArray("products");
                            productList = Product.fromJson(productsJson);

                            if(productList != null) {
                                for(int i=0; i<productList.size(); i++){
                                    Log.d("*Products", "*Product Name: " + productList.get(i).getName());
                                    Log.d("*Products", "*Price: " + productList.get(i).getActualPrice());
                                }
                                onDataRequestListener.onDataReady(productList);
                            }else {
                                Log.d(TAG, "data is null ");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance(ctx).addToRequestQueue(jsonObjReq);
    }

}
