package com.mia.mvvvmcarchitecture.common

import android.app.Application
import com.mia.mvvmarchitecture.common.dependencyInjection.app.AppComponent
import com.mia.mvvmarchitecture.common.dependencyInjection.app.AppModule
import com.mia.mvvmarchitecture.common.dependencyInjection.app.DaggerAppComponent

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class CommonApplication : Application() {

    private val mAppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule()).build()
    }

    override fun onCreate() {
        super.onCreate()
    }

    fun getAppComponent(): AppComponent {
        return mAppComponent;
    }
}