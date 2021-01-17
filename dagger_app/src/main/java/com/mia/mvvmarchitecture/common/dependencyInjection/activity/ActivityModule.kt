package com.mia.mvvmarchitecture.common.dependencyInjection.activity

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.mia.mvvmarchitecture.common.dependencyInjection.app.AppComponent
import com.mia.mvvmarchitecture.ui.common.fragmentframehelper.FragmentFrameHelper
import com.mia.mvvmarchitecture.ui.common.fragmentframehelper.FragmentFrameWrapper
import com.mia.mvvvmcarchitecture.ui.common.controllers.BackPressDispatcher
import com.mia.mvvvmcarchitecture.ui.common.screensnavigator.ScreenNavigatior
import dagger.Module
import dagger.Provides

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
@Module
class ActivityModule(
    private val mActivity: FragmentActivity,
    private val mAppComponent: AppComponent
) {

    @Provides
    fun getStackOverFlowApi() = mAppComponent.getStackOverFlowApi()

    @Provides
    fun getEventBus() = mAppComponent.getEventBus()

    @Provides
    fun getActivity() = mActivity

    @Provides
    fun getContext() = mActivity as Context

    @Provides
    fun getFragmentManager() = mActivity.supportFragmentManager

    @Provides
    fun getLayoutInflater() = LayoutInflater.from(mActivity)

    @Provides
    fun getBackPressDispatcher() = mActivity as BackPressDispatcher

    @Provides
    fun getFragmentFrameWrapper() = mActivity as FragmentFrameWrapper

    @Provides
    fun getFragmentFrameHelper(
        frameWrapper: FragmentFrameWrapper,
        fragmentManager: FragmentManager
    ): FragmentFrameHelper {
        return FragmentFrameHelper(mActivity, frameWrapper, fragmentManager)
    }

    @Provides
    @ActivityScope
    fun getScreenNavigator(fragmentFrameHelper: FragmentFrameHelper) =
        ScreenNavigatior(fragmentFrameHelper)
}