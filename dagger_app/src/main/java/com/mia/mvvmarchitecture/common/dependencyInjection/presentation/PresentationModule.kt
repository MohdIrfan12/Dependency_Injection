package com.mia.mvvmarchitecture.common.dependencyInjection.presentation

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.mia.mvvmarchitecture.networking.EndpointFactory
import com.mia.mvvmarchitecture.questions.UsecaseFactory
import com.mia.mvvvmcarchitecture.common.permissions.FragmentPermissionsHelper
import com.mia.mvvvmcarchitecture.networking.StackoverflowApi
import com.mia.mvvvmcarchitecture.ui.common.ViewFactory
import com.mia.mvvvmcarchitecture.ui.common.dialogs.DialogsManager
import com.mia.mvvvmcarchitecture.ui.common.toasthelper.ToastHelper
import com.mia.mvvvmcarchitecture.common.permissions.ActivityPermissionsHelper
import dagger.Module
import dagger.Provides

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */

@Module
class PresentationModule {

    @Provides
    @PresentationScope
    fun getActivityPermissionsHelper(activity: FragmentActivity) =
        ActivityPermissionsHelper(activity)

    @Provides
    fun getViewFactory(layoutInflater: LayoutInflater) = ViewFactory(layoutInflater)

    @Provides
    internal fun getMessageDisplayer(context: Context) = ToastHelper(context)

    @Provides
    fun getDialogsManager(context: Context, fragmentManager: FragmentManager) =
        DialogsManager(context, fragmentManager)

    @Provides
    @PresentationScope
    fun getFragmentPermissionsHelper(mFragment: Fragment) = FragmentPermissionsHelper(mFragment)

    @Provides
    fun getUsecaseFactory(endpointFactory: EndpointFactory) = UsecaseFactory(endpointFactory)


    @Provides
    fun getEndpointFactory(stackoverflowApi: StackoverflowApi) = EndpointFactory(stackoverflowApi)
}