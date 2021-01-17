package com.mia.mvvmarchitecture.common.dependencyInjection.presentation

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.mia.mvvmarchitecture.common.dependencyInjection.activity.ActivityComponent
import com.mia.mvvmarchitecture.networking.EndpointFactory
import com.mia.mvvmarchitecture.questions.UsecaseFactory
import com.mia.mvvmarchitecture.ui.common.fragmentframehelper.FragmentFrameHelper
import com.mia.mvvvmcarchitecture.common.permissions.FragmentPermissionsHelper
import com.mia.mvvvmcarchitecture.networking.StackoverflowApi
import com.mia.mvvvmcarchitecture.ui.common.ViewFactory
import com.mia.mvvvmcarchitecture.ui.common.dialogs.DialogsManager
import com.mia.mvvvmcarchitecture.ui.common.toasthelper.ToastHelper
import com.mia.mvvmarchitecture.ui.common.viewmodel.ViewModelProviderFactory
import com.mia.mvvvmcarchitecture.common.permissions.ActivityPermissionsHelper
import dagger.Module
import dagger.Provides

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */

@Module
class PresentationModule(private val mActivityComponent: ActivityComponent) {

    @Provides
    fun getStackOverFlowApi() = mActivityComponent.getStackOverFlowApi()

    @Provides
    fun getEventBus() = mActivityComponent.getEventBus()

    @Provides
    fun getScreenNavigatior() = mActivityComponent.getScreenNavigator()

    @Provides
    fun getBackPressDispatcher() = mActivityComponent.getBackPressDispatcher()

    @Provides
    @ScreenScope
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
    @ScreenScope
    fun getFragmentPermissionsHelper(mFragment: Fragment) = FragmentPermissionsHelper(mFragment)

    @Provides
    fun getUsecaseFactory() = UsecaseFactory(getEndpointFactory(getStackOverFlowApi()))

    @Provides
    fun getViewModelProviderFactory() = ViewModelProviderFactory(this)

    @Provides
    fun getContext() = mActivityComponent.getContext()

    @Provides
    fun getActivity() = mActivityComponent.getActivity()

    @Provides
    fun getFragmentManager() = mActivityComponent.getFragmentManager();

    @Provides
    fun getLayoutInflater() = mActivityComponent.getLayoutInflater()

    @Provides
    fun getEndpointFactory(stackoverflowApi: StackoverflowApi) =
        EndpointFactory(stackoverflowApi)
}