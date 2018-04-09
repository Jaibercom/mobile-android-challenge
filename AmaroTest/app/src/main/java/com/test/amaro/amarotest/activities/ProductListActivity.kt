package com.test.amaro.amarotest.activities

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.test.amaro.amarotest.model.Product
import com.test.amaro.amarotest.R
import com.test.amaro.amarotest.fragments.ProductsListFragment
import timber.log.Timber

class ProductListActivity : AppCompatActivity(), ProductsListFragment.OnListFragmentListener {

    private val TAG = "ProductListActivity"

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var mTwoPane: Boolean = false
    private var fragment: ProductsListFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        Timber.i("ProductListActivity")

        fragment = ProductsListFragment.frament

        // Add fragment to Activity
        fragmentManager
                .beginTransaction()
                .replace(R.id.list_container, fragment)
                .commit()


        mTwoPane = false
        /*if (findViewById(R.id.product_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }*/

    }


    override fun onItemClick(product: Product) {
        Log.d(TAG, "onItemClick: " + product.name)

        if (mTwoPane) {
            /*Bundle arguments = new Bundle();
            arguments.putString(PersonaDetailFragment.ARG_ITEM_ID, id);
            PersonaDetailFragment fragment = new PersonaDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.persona_detail_container, fragment).commit();
            */
        } else {
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra(ProductDetailActivity.PRODUCT, product as Parcelable)

            intent.putParcelableArrayListExtra(ProductDetailActivity.SIZES, product.sizes)

            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu items for use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.main_activity_actions, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar items
        when (item.itemId) {
            R.id.action_filter -> {
                //actionFilterProductsOnSale()
                Log.d(TAG, "action_filter")
                return true
            }
            R.id.action_sort -> {
                actionSort()
                Log.d(TAG, "action_sort")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //  sorting by price (lowest first)
    private fun actionFilterProductsOnSale() {
        //fragment!!.filterProductsOnSale()
    }

    //  sorting by price (lowest first)
    private fun actionSort() {
        fragment!!.sortByLowestPrice()
    }

}
