package com.test.amaro.amarotest.Views.ProductsList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.test.amaro.amarotest.Model.Product;
import com.test.amaro.amarotest.Model.Size;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.Views.ProductDetail.ProductDetailActivity;

import java.util.ArrayList;
import java.util.List;

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


        mTwoPane = false;
        /*if (findViewById(R.id.product_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }*/

    }


    @Override
    public void onItemClick(Product product) {
        Log.d(TAG, "onItemClick: " + product.getName());

        if (mTwoPane) {
            /*Bundle arguments = new Bundle();
            arguments.putString(PersonaDetailFragment.ARG_ITEM_ID, id);
            PersonaDetailFragment fragment = new PersonaDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.persona_detail_container, fragment).commit();
            */
        } else {
            Intent intent = new Intent(this, ProductDetailActivity.class);
            intent.putExtra(ProductDetailActivity.PRODUCT, (Parcelable) product);
            intent.putParcelableArrayListExtra(ProductDetailActivity.SIZES, (ArrayList) product.getSizes());

            startActivity(intent);
        }


    }
}
