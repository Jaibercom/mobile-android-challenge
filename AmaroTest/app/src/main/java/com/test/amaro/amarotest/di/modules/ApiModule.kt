package com.test.amaro.amarotest.di.modules

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.amaro.amarotest.HOST_IP
import com.test.amaro.amarotest.api.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule(private val app: Application) {

    @Provides
    fun providesApi(retrofit: Retrofit): ApiService{
        return retrofit.create<ApiService>(ApiService::class.java)
    }

    @Provides
    fun providesRetrofit(gsonConverter: GsonConverterFactory): Retrofit{

        return Retrofit.Builder()
                .baseUrl(HOST_IP)
                .addConverterFactory(gsonConverter)
                .build()
    }

    @Provides
    fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory{
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun providesGson(): Gson{
        return GsonBuilder().disableHtmlEscaping().create()
    }

}