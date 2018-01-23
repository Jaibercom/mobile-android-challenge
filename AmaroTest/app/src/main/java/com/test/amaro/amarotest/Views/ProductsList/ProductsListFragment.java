package com.test.amaro.amarotest.Views.ProductsList;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.amaro.amarotest.Model.Product;
import com.test.amaro.amarotest.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsListFragment extends Fragment implements ProductsListInteractor.OnDataRequestListener, AdapterRecyclerView.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private AdapterRecyclerView adapter;
    ProductsListInteractor interactor;

    private List<Product> productList;

    private final String TAG = "ProductsListFragment";

    public ProductsListFragment() {
        // Required empty public constructor
    }

    public interface OnListFragmentListener {
        public void onItemClick(Product product);
    }

    private OnListFragmentListener onListFragmentListener;


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

        recyclerViewInit(view);

        interactor = new ProductsListInteractor(getActivity().getApplicationContext(), this);
        interactor.requestProducts();

        return view;

    }

    private void recyclerViewInit(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        //specify an adapter
        adapter = new AdapterRecyclerView(getActivity().getApplicationContext(), this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentListener) {
            onListFragmentListener = (OnListFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " you should implement the listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onListFragmentListener = null;
    }


    @Override
    public void onDataReady(List<Product> _productList) {
        productList = _productList;
        adapter.updateList(productList);
    }

    @Override
    public void onItemClick(RecyclerView.ViewHolder viewHolder, int pos) {
        loadDetail(pos);
    }

    public void loadDetail(int pos) {

        Product product = productList.get(pos);

        if (onListFragmentListener != null) {
            onListFragmentListener.onItemClick(product);
        }
    }
}
