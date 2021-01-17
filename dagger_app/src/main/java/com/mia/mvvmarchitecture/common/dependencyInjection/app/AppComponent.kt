package com.mia.mvvmarchitecture.common.dependencyInjection.app

import com.mia.mvvvmcarchitecture.common.eventbus.EventBus
import com.mia.mvvvmcarchitecture.networking.StackoverflowApi
import dagger.Component

/**
 * Created by Mohd Irfan on 18/01/21.
 */
@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun getStackOverFlowApi(): StackoverflowApi
    fun getEventBus(): EventBus
}