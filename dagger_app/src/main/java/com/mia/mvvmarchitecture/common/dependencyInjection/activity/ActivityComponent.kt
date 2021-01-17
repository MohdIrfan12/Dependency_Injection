package com.mia.mvvmarchitecture.common.dependencyInjection.activity

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.mia.mvvmarchitecture.common.dependencyInjection.app.AppComponent
import com.mia.mvvmarchitecture.ui.common.fragmentframehelper.FragmentFrameHelper
import com.mia.mvvvmcarchitecture.common.eventbus.EventBus
import com.mia.mvvvmcarchitecture.networking.StackoverflowApi
import com.mia.mvvvmcarchitecture.ui.common.controllers.BackPressDispatcher
import com.mia.mvvvmcarchitecture.ui.common.screensnavigator.ScreenNavigatior
import dagger.Component

/**
 * Created by Mohd Irfan on 18/01/21.
 */
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun getStackOverFlowApi(): StackoverflowApi

    fun getContext(): Context

    fun getEventBus(): EventBus

    fun getActivity(): FragmentActivity

    fun getFragmentManager(): FragmentManager

    fun getLayoutInflater(): LayoutInflater

    fun getBackPressDispatcher(): BackPressDispatcher

    fun getScreenNavigator(): ScreenNavigatior
}