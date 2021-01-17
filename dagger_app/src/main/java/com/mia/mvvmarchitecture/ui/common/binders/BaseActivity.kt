package com.mia.mvvvmcarchitecture.ui.common.controllers

import androidx.appcompat.app.AppCompatActivity
import com.mia.mvvvmcarchitecture.common.CommonApplication
import com.mia.mvvmarchitecture.common.dependencyInjection.activity.ActivityModule
import com.mia.mvvmarchitecture.common.dependencyInjection.activity.DaggerActivityComponent
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.DaggerPresentationComponent
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.PresentationModule

abstract class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as CommonApplication).getAppComponent()

    protected val activityComponent by lazy {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this, appComponent)).build()
    }

    protected val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent)).build()
    }
}