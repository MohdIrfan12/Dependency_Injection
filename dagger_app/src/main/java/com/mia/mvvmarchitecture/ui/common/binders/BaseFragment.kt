package com.mia.mvvvmcarchitecture.ui.common.controllers

import androidx.fragment.app.Fragment
import com.mia.mvvvmcarchitecture.common.CommonApplication
import com.mia.mvvmarchitecture.common.dependencyInjection.activity.ActivityModule
import com.mia.mvvmarchitecture.common.dependencyInjection.activity.DaggerActivityComponent
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.DaggerPresentationComponent
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.PresentationModule

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
abstract class BaseFragment : Fragment() {

    private val appComponent get() = (activity!!.application as CommonApplication).getAppComponent()

    protected val activityComponent by lazy {
        DaggerActivityComponent.builder().activityModule(ActivityModule(activity!!, appComponent)).build()
    }

    protected val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent)).build()
    }
}