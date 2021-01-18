package com.mia.mvvmarchitecture.common.dependencyInjection.activity

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.mia.mvvmarchitecture.ui.common.fragmentframehelper.FragmentFrameHelper
import com.mia.mvvmarchitecture.ui.common.fragmentframehelper.FragmentFrameWrapper
import com.mia.mvvvmcarchitecture.ui.common.controllers.BackPressDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
@Module
@InstallIn(ActivityComponent::class)
class ActivityModule() {

    @Provides
    fun appCompatActivity(activity: Activity) = activity as AppCompatActivity


    @Provides
    fun getFragmentManager(mActivity: AppCompatActivity) = mActivity.supportFragmentManager

    @Provides
    fun getLayoutInflater(mActivity: AppCompatActivity) = LayoutInflater.from(mActivity)

    @Provides
    fun getBackPressDispatcher(mActivity: AppCompatActivity) = mActivity as BackPressDispatcher

    @Provides
    fun getFragmentFrameWrapper(mActivity: AppCompatActivity) = mActivity as FragmentFrameWrapper

    @Provides
    fun getFragmentFrameHelper(
        mActivity: AppCompatActivity,
        frameWrapper: FragmentFrameWrapper,
        fragmentManager: FragmentManager
    ): FragmentFrameHelper {
        return FragmentFrameHelper(mActivity, frameWrapper, fragmentManager)
    }
}