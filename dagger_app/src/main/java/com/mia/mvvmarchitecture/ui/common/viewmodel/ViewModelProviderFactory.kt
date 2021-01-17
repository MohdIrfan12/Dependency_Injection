package com.mia.mvvmarchitecture.ui.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.mia.mvvmarchitecture.common.dependencyInjection.presentation.PresentationModule
import com.mia.mvvvmcarchitecture.ui.questionlist.QuestionDetailViewModel
import com.mia.mvvvmcarchitecture.ui.questionlist.QuestionListViewModel

/**
 * Created by Mohd Irfan on 31/12/20.
 */
class ViewModelProviderFactory(private val mPresentationModule: PresentationModule) :
    NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(QuestionListViewModel::class.java)) {
            return QuestionListViewModel(
                mPresentationModule.getUsecaseFactory().getFetchQuestionsListUseCase(),
                mPresentationModule.getEventBus()
            ) as T

        } else if (modelClass.isAssignableFrom(QuestionDetailViewModel::class.java)) {
            return QuestionDetailViewModel(
                mPresentationModule.getUsecaseFactory().getFetchQuestionsDetailUseCase(),
                mPresentationModule.getBackPressDispatcher()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}