package com.mia.mvvmarchitecture.ui.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import javax.inject.Provider

/**
 * Created by Mohd Irfan on 31/12/20.
 */
class ViewModelProviderFactory(var providesMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return providesMap.get(modelClass)?.get() as T
    }
}