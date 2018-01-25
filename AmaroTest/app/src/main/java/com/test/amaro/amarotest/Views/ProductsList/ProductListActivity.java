package com.test.amaro.amarotest.Views.ProductsList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.test.amaro.amarotest.Model.Product;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.Views.ProductDetail.ProductDetailActivity;
import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity implements ProductsListFragment.OnListFragmentListener{

    private final String TAG = "ProductListActivity";

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private ProductsListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        //requestProducts();
        //Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        //setSupportActionBar(toolbar);

        fragment = ProductsListFragment.getFrament();

        // Add fragment to Activity
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list_container, fragment )
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_filter:
                actionFilterProductsOnSale();
                Log.d(TAG, "action_filter");
                return true;
            case R.id.action_sort:
                actionSort();
                Log.d(TAG, "action_sort" );
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //  sorting by price (lowest first)
    private void actionFilterProductsOnSale() {
        fragment.filterProductsOnSale();
    }

    //  sorting by price (lowest first)
    private void actionSort() {
        fragment.sortByLowestPrice();
    }

}
