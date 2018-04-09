package com.test.amaro.amarotest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by jaiber on 1/19/18.
 */
@Parcelize
data class Size(

    var available: Boolean?,
    var size: String?,
    var sku: String?
) : Parcelable