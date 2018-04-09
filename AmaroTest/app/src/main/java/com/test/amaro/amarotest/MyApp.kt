package com.test.amaro.amarotest

import android.app.Activity
import android.app.Application
import android.app.Fragment
import android.content.Context
import android.support.multidex.MultiDex
import android.util.Log

import com.test.amaro.amarotest.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class MyApp : Application(), HasActivityInjector, HasFragmentInjector  {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> {
       return activityInjector
    }

    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }


    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        // Multidex
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        // Timber
        Timber.plant(Timber.DebugTree())
        Timber.i("onCreate")
        //Log.d("TAG", "onCreate")

        // Dagger 2
        DaggerAppComponent.create().inject(this)
    }

}