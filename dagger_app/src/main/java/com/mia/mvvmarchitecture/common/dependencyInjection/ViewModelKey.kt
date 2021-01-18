package com.mia.mvvmarchitecture.common.dependencyInjection

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Mohd Irfan on 18/01/21.
 */
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)