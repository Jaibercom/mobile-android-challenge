package com.test.amaro.amarotest

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

class MyApp : Application() {


    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        // Multidex
        MultiDex.install(this)
    }

}