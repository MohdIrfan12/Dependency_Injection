package com.mia.mvvmarchitecture.common.dependencyInjection.presentation


import androidx.fragment.app.Fragment
import com.mia.mvvvmcarchitecture.ui.QuestionsActivity
import com.mia.mvvvmcarchitecture.ui.common.dialogs.promptdialog.PromptDialog
import com.mia.mvvvmcarchitecture.ui.questiondetail.QuestionDetailsFragment
import com.mia.mvvvmcarchitecture.ui.questionlist.QuestionsListFragment
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by Mohd Irfan on 18/01/21.
 */
@PresentationScope
@Subcomponent(modules = [PresentationModule::class, ViewModelModule::class])
interface PresentationComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun fragment(fragment: Fragment?): Builder
        fun presentationModule(presentationModule: PresentationModule): Builder
        fun viewModelModule(viewModelModule: ViewModelModule): Builder
        fun build(): PresentationComponent
    }

    fun inject(questionsActivity: QuestionsActivity)
    fun inject(promptDialog: PromptDialog)
    fun inject(promptDialog: QuestionDetailsFragment)
    fun inject(questionsListFragment: QuestionsListFragment)
}