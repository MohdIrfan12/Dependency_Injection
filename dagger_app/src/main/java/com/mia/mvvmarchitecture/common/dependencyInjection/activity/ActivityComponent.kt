package com.mia.mvvmarchitecture.common.dependencyInjection.activity

import com.mia.mvvmarchitecture.common.dependencyInjection.app.AppComponent
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.PresentationComponent
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.PresentationModule
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.ViewModelModule
import com.mia.mvvvmcarchitecture.ui.common.screensnavigator.ScreenNavigatior
import dagger.Component

/**
 * Created by Mohd Irfan on 18/01/21.
 */
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun getScreenNavigator(): ScreenNavigatior

    fun newPresentationComponent(
        module: PresentationModule,
        viewModelModule: ViewModelModule
    ): PresentationComponent
}