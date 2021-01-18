package com.mia.mvvvmcarchitecture.common

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
@HiltAndroidApp
class CommonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}