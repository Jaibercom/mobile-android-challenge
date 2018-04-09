package com.test.amaro.amarotest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by jaiber on 1/19/18.
 */
@Parcelize
data class Products(
        var products: ArrayList<Product>
) : Parcelable