package com.mia.mvvmarchitecture.common.dependencyInjection.app

import com.mia.mvvvmcarchitecture.common.eventbus.EventBus
import com.mia.mvvvmcarchitecture.networking.Constants
import com.mia.mvvvmcarchitecture.networking.Constants.INCREASED_TIME_OUT
import com.mia.mvvvmcarchitecture.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */

@Module
class AppModule {

    @Provides
    @AppScope
    @Named("retrofit1")
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @AppScope
    @Named("retrofitWithTimeout")
    fun retrofitWithIncreasedTimeout(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    @AppScope
    fun getHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.readTimeout(INCREASED_TIME_OUT.toLong(), TimeUnit.MINUTES)
        httpClient.connectTimeout(INCREASED_TIME_OUT.toLong(), TimeUnit.MINUTES)
        return httpClient.build()
    }

    @Provides
    @AppScope
    fun getStackOverFlowApi(@Named("retrofit1") retrofit: Retrofit): StackoverflowApi {
        return retrofit.create(StackoverflowApi::class.java)
    }

    @Provides
    @AppScope
    fun getEventBus(): EventBus {
        return EventBus();
    }
}