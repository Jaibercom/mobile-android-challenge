package com.test.amaro.amarotest.Views.ProductsList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.test.amaro.amarotest.Model.Product;
import com.test.amaro.amarotest.R;

public class ProductListActivity extends AppCompatActivity implements ProductsListFragment.OnListFragmentListener{

    private final String TAG = "ProductListActivity";

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

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


    @Override
    public void onItemClick(Product product) {
        Log.d(TAG, "onItemClick: " + product.getName());
    }
}
