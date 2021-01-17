package com.mia.mvvmarchitecture.common.dependencyInjection.presentation;

import androidx.lifecycle.ViewModel;


import com.mia.mvvmarchitecture.questions.UsecaseFactory;
import com.mia.mvvmarchitecture.ui.common.viewmodel.ViewModelProviderFactory;
import com.mia.mvvvmcarchitecture.common.eventbus.EventBus;
import com.mia.mvvvmcarchitecture.ui.common.controllers.BackPressDispatcher;
import com.mia.mvvvmcarchitecture.ui.questionlist.QuestionDetailViewModel;
import com.mia.mvvvmcarchitecture.ui.questionlist.QuestionListViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Created by Mohd Irfan on 31/12/20.
 */
@Module
public class ViewModelModule {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }

    @Provides
    ViewModelProviderFactory getViewModelProviderFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providesMap) {
        return new ViewModelProviderFactory(providesMap);
    }

    @Provides
    @IntoMap
    @ViewModelKey(QuestionListViewModel.class)
    ViewModel getQuestionListViewModel(UsecaseFactory usecaseFactory, EventBus eventBus) {
        return new QuestionListViewModel(usecaseFactory.getFetchQuestionsListUseCase(), eventBus);
    }

    @Provides
    @IntoMap
    @ViewModelKey(QuestionDetailViewModel.class)
    ViewModel getQuestionDetailViewModel(UsecaseFactory usecaseFactory, BackPressDispatcher backPressDispatcher) {
        return new QuestionDetailViewModel(usecaseFactory.getFetchQuestionsDetailUseCase(), backPressDispatcher);
    }
}
