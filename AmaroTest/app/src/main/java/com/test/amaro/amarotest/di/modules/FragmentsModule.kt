package com.test.amaro.amarotest.di.modules

import com.test.amaro.amarotest.fragments.ProductsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class FragmentsModule {
    @Singleton
    @ContributesAndroidInjector
    abstract fun provideProductListFragment(): ProductsListFragment
}