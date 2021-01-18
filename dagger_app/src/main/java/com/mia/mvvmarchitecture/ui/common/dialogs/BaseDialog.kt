package com.mia.mvvvmcarchitecture.ui.common.dialogs

import androidx.fragment.app.DialogFragment
import com.mia.mvvvmcarchitecture.common.CommonApplication
import com.mia.mvvmarchitecture.common.dependencyInjection.activity.ActivityModule
import com.mia.mvvmarchitecture.common.dependencyInjection.activity.DaggerActivityComponent
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.PresentationModule
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.ViewModelModule

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
abstract class BaseDialog : DialogFragment() {

    private val appComponent get() = (activity!!.application as CommonApplication).getAppComponent()

    protected val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .activityModule(ActivityModule(activity!!))
            .build()
    }

    protected val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule(), ViewModelModule())
    }
}