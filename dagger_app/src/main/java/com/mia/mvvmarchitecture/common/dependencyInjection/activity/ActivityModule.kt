package com.mia.mvvmarchitecture.common.dependencyInjection.activity

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.mia.mvvmarchitecture.ui.common.fragmentframehelper.FragmentFrameHelper
import com.mia.mvvmarchitecture.ui.common.fragmentframehelper.FragmentFrameWrapper
import com.mia.mvvvmcarchitecture.ui.common.controllers.BackPressDispatcher
import dagger.Module
import dagger.Provides

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
@Module
class ActivityModule(private val mActivity: FragmentActivity) {

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
}