package com.mia.mvvvmcarchitecture.ui.common.controllers

import androidx.appcompat.app.AppCompatActivity
import com.mia.mvvvmcarchitecture.common.CommonApplication
import com.mia.mvvvmcarchitecture.common.dependencyInjection.ActivityCompositionRoot
import com.mia.mvvvmcarchitecture.common.dependencyInjection.ControllerCompositionRoot

abstract class BaseActivity : AppCompatActivity() {

    protected val mActivityCompositionRoot by lazy {
        ActivityCompositionRoot(this, (application as CommonApplication).getCompositionRoot())
    }

    protected val mControllerCompositionRoot by lazy {
        ControllerCompositionRoot(mActivityCompositionRoot)
    }

}