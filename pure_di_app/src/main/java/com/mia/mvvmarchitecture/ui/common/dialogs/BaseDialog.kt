package com.mia.mvvvmcarchitecture.ui.common.dialogs

import androidx.fragment.app.DialogFragment
import com.mia.mvvvmcarchitecture.common.CommonApplication
import com.mia.mvvvmcarchitecture.common.dependencyInjection.ActivityCompositionRoot
import com.mia.mvvvmcarchitecture.common.dependencyInjection.ControllerCompositionRoot

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
abstract class BaseDialog : DialogFragment() {

    protected val mActivityCompositionRoot by lazy {
        ActivityCompositionRoot(
            requireActivity(),
            (requireActivity().application as CommonApplication).getCompositionRoot()
        )
    }

    protected val mControllerCompositionRoot by lazy {
        ControllerCompositionRoot(mActivityCompositionRoot)
    }
}