package com.test.amaro.amarotest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.test.amaro.amarotest.Adapters.AdapterRecyclerView;
import com.test.amaro.amarotest.Model.Product;
import com.test.amaro.amarotest.WebServices.ConfigURL;
import com.test.amaro.amarotest.WebServices.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private AdapterRecyclerView adapter;

    private List<Product> productList;

    private final String TAG = "ProductsListFragment";

    public ProductsListFragment() {
        // Required empty public constructor
    }


    public static ProductsListFragment getFrament() {
        return new ProductsListFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Manejo de argumentos
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_products, container, false);

        //View recyclerView = v.findViewById(R.id.recycler);

        //assert recyclerView != null;
        //prepararLista((RecyclerView) recyclerView);
        recyclerViewInit(view);
        requestProducts();
        return view;

    }

    private void recyclerViewInit(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //specify an adapter
        adapter = new AdapterRecyclerView(getActivity().getApplicationContext());
        mRecyclerView.setAdapter(adapter);
    }


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
                                    Log.d("*Products", "*Product Name: " + productList.get(i).getName());
                                    Log.d("*Products", "*Price: " + productList.get(i).getActualPrice());
                                }
                                adapter.updateList(productList);
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
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(jsonObjReq);
    }
}
