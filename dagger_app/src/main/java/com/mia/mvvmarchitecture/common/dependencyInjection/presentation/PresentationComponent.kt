package com.mia.mvvmarchitecture.common.dependencyInjection.presentation


import com.mia.mvvvmcarchitecture.ui.common.dialogs.promptdialog.PromptDialog
import com.mia.mvvvmcarchitecture.ui.common.screensnavigator.ScreenNavigatior
import com.mia.mvvvmcarchitecture.ui.questiondetail.QuestionDetailsFragment
import com.mia.mvvvmcarchitecture.ui.questionlist.QuestionsListFragment
import dagger.Subcomponent

/**
 * Created by Mohd Irfan on 18/01/21.
 */
@PresentationScope
@Subcomponent(modules = [PresentationModule::class, ViewModelModule::class])
interface PresentationComponent {

    fun getScreenNavigator(): ScreenNavigatior


    fun inject(promptDialog: PromptDialog)
    fun inject(promptDialog: QuestionDetailsFragment)
    fun inject(questionsListFragment: QuestionsListFragment)
}