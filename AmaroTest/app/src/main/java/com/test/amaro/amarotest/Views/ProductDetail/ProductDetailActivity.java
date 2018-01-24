package com.test.amaro.amarotest.Views.ProductDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaouan.compoundlayout.CircleGradientRadioLayout;
import com.test.amaro.amarotest.Model.Product;
import com.test.amaro.amarotest.Model.Size;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.Views.ProductsList.ProductListActivity;

import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    private static final String TAG = "ProductDetailActivity";
    public static final String PRODUCT = "extra.product";
    public static final String SIZES = "extra.sizes";
    private Product product;

    private CircleGradientRadioLayout sizeViews[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        sizeViews = new CircleGradientRadioLayout[5];

        sizeViews[0] = findViewById(R.id.size_pp);
        sizeViews[1] = findViewById(R.id.size_p);
        sizeViews[2] = findViewById(R.id.size_m);
        sizeViews[3] = findViewById(R.id.size_g);
        sizeViews[4] = findViewById(R.id.size_gg);

        //sizeViews[0].setVisibility(View.GONE);
        //sizeViews[4].setVisibility(View.GONE);


        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }

        if(getIntent().hasExtra(PRODUCT)  && getIntent().hasExtra(SIZES)) {
            product = (Product) getIntent().getParcelableExtra(PRODUCT);
            Log.d(TAG, "Product: " + product.getName());
            //Log.d(TAG, "Product sizes: " + product.getSizes().size());
            List<Size> sizes = (List) getIntent().getParcelableArrayListExtra(SIZES);
            product.setSizes(sizes);

            updateDisplay();

        }

    }

    void updateDisplay(){

        if(product != null){

            ((TextView) findViewById(R.id.tvName)).setText(product.getName());
            ((TextView) findViewById(R.id.tvActualPrice)).setText(product.getActualPrice());

            if(!product.getActualPrice().equals(product.getRegularPrice()) ) {
                ((TextView) findViewById(R.id.tvRegularPrice)).setText(product.getRegularPrice());
            }
            //((TextView) findViewById(R.id.contenido)).setText(product.getCodeColor());
            Glide.with(this)
                    .load(product.getImage())
                    .into((ImageView) findViewById(R.id.ivImage));


            if(product.getSizes() != null) {
                for (int i=0; i<product.getSizes().size(); i++) {
                    //Log.d(TAG, "Size: " + size.getSize() + " available: " + size.getAvailable());
                    if (product.getSizes().get(i).getAvailable() == false) {
                        Log.d(TAG, ""+i+" is not available ");
                        sizeViews[i].setVisibility(View.GONE);
                    }
                }
            }else{
                Log.d(TAG, "Sizes is null ");
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, ProductListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
