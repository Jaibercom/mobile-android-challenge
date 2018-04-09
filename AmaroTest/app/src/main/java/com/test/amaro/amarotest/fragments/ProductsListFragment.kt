package com.test.amaro.amarotest.fragments


import android.app.Fragment
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.test.amaro.amarotest.model.Product
import com.test.amaro.amarotest.R
import com.test.amaro.amarotest.Views.ProductsList.AdapterRecyclerView
import com.test.amaro.amarotest.Views.ProductsList.ProductsListInteractor
import com.test.amaro.amarotest.api.ApiService
import dagger.android.AndroidInjection
import timber.log.Timber

import java.util.ArrayList

import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class ProductsListFragment : Fragment(), ProductsListInteractor.OnDataRequestListener, AdapterRecyclerView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private var mRecyclerView: RecyclerView? = null
    private var adapter: AdapterRecyclerView? = null
    private var refreshLayout: SwipeRefreshLayout? = null
    private lateinit var interactor: ProductsListInteractor

    private var productList: List<Product>? = null
    private var productsSortbyLowestList: List<Product>? = null
    private var productsOnSaleList: MutableList<Product>? = null

    private val TAG = "ProductsListFragment"


    @Inject
    lateinit var api: ApiService



    private var onListFragmentListener: OnListFragmentListener? = null

    interface OnListFragmentListener {
        fun onItemClick(product: Product)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            // Manejo de argumentos
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products, container, false)
        Timber.i("***onCreateView" )

        // Get refreshLayout
        refreshLayout = view.findViewById<View>(R.id.swipeRefresh) as SwipeRefreshLayout
        refreshLayout!!.setOnRefreshListener(this)

        recyclerViewInit(view)

        interactor = ProductsListInteractor(activity!!.applicationContext, this, api)
        interactor.requestProducts()

        return view

    }

    private fun recyclerViewInit(view: View) {

        mRecyclerView = view.findViewById<View>(R.id.recyclerView) as RecyclerView

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        val gridLayoutManager = GridLayoutManager(activity!!.applicationContext, 2)
        mRecyclerView!!.layoutManager = gridLayoutManager

        //specify an adapter
        adapter = AdapterRecyclerView(activity!!.applicationContext, this)
        mRecyclerView!!.adapter = adapter
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnListFragmentListener) {
            onListFragmentListener = context
        } else {
            throw RuntimeException(context!!.toString() + " you should implement the listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        onListFragmentListener = null
    }


    override fun onDataReady(_productList: List<Product>?) {
        productList = _productList
        adapter!!.updateList(productList)
        // Animation Stop
        refreshLayout!!.isRefreshing = false
    }

    override fun onItemClick(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        loadDetail(pos)
    }


    // SwipeRefreshLayout.OnRefreshListener
    override fun onRefresh() {

        if (interactor != null)
            interactor!!.requestProducts()

    }

    fun loadDetail(pos: Int) {

        val product = productList!![pos]

        if (onListFragmentListener != null) {
            onListFragmentListener!!.onItemClick(product)
        }
    }

    fun sortByLowestPrice() {

        if (productList != null) {
            productsSortbyLowestList = productList
            //Collections.sort(productsSortbyLowestList);
            adapter!!.updateList(productsSortbyLowestList)
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    fun filterProductsOnSale() {

        if (productList != null) {

            productsOnSaleList = ArrayList()

            for (product in productList!!) {
                Log.d(TAG, "Sale: " + product.onSale!!)
                if (product.onSale!!) {
                    productsOnSaleList!!.add(product)
                }
            }
            adapter!!.updateList(productsOnSaleList)
        }
    }

    companion object {


        val frament: ProductsListFragment
            get() = ProductsListFragment()
    }

}// Required empty public constructor
