package com.test.amaro.amarotest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by jaiber on 1/19/18.
 */
@Parcelize
data class Product (
    var name: String?,
    var style: String?,
    var codeColor: String?,
    var colorSlug: String?,
    var color: String?,
    var onSale: Boolean?,
    var regularPrice: String?,
    var actualPrice: String?,
    var discountPercentage: String?,
    var installments: String?,
    var image: String?,
    var sizes: ArrayList<Size>?

) : Parcelable