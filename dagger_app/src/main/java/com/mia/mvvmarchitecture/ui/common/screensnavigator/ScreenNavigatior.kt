package com.mia.mvvvmcarchitecture.ui.common.screensnavigator

import com.mia.mvvmarchitecture.common.dependencyInjection.activity.ActivityScope
import com.mia.mvvmarchitecture.ui.common.fragmentframehelper.FragmentFrameHelper
import com.mia.mvvvmcarchitecture.ui.questiondetail.QuestionDetailsFragment
import com.mia.mvvvmcarchitecture.ui.questionlist.QuestionsListFragment
import javax.inject.Inject

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
@ActivityScope
class ScreenNavigatior @Inject constructor(val mFragmentFrameHelper: FragmentFrameHelper) {

    fun navigateToQuestionList() {
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(QuestionsListFragment.newInstance())
    }

    fun navigateToQuestionDetail(mQuestionId: String?) {
        mFragmentFrameHelper.replaceFragment(QuestionDetailsFragment.newInstance(mQuestionId))
    }
}