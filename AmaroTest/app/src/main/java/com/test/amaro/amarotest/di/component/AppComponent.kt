package com.test.amaro.amarotest.di.component

import com.test.amaro.amarotest.MyApp
import com.test.amaro.amarotest.di.modules.ActivitiesModule
import com.test.amaro.amarotest.di.modules.ApiModule
import com.test.amaro.amarotest.di.modules.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ApiModule::class), (ActivitiesModule::class)])
interface AppComponent {
    fun inject(app: MyApp)
}