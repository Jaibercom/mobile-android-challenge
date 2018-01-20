package com.test.amaro.amarotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity {

    private List<Product> productList;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //requestProducts();

        // Add fragment to Activity
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list_container, ProductsListFragment.getFrament())
                .commit();


    }

/*
    private void requestProducts() {

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
                                    Log.d("*Products", "*Products: " + productList.get(i).getName());
                                }
                                //adapter.updateList(studentList);
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
        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjReq);
    }
*/
}
