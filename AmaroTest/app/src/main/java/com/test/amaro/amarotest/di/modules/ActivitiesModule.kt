package com.test.amaro.amarotest.di.modules

import com.test.amaro.amarotest.activities.ProductListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivitiesModule {
    @Singleton
    @ContributesAndroidInjector
    abstract fun provideProductListActivity(): ProductListActivity
}