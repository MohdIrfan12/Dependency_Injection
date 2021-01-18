package com.mia.mvvvmcarchitecture.ui.common.dialogs

import android.app.Application
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import com.mia.mvvmarchitecture.R
import com.mia.mvvvmcarchitecture.ui.common.dialogs.infodialog.InfoDialog
import com.mia.mvvvmcarchitecture.ui.common.dialogs.promptdialog.PromptDialog
import javax.inject.Inject

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
class DialogsManager @Inject constructor(private val mContext: Application, private val mFragmentManager: FragmentManager) {

    fun showErrorInfoPrompt(@Nullable tag: String?) {
        val mInfoDialog = InfoDialog.newInstance(
            getString(R.string.text_error_promt_title),
            getString(R.string.text_network_call_failed),
            getString(R.string.text_ok)
        )
        mInfoDialog.show(mFragmentManager, tag)
    }

    fun showErrorPrompt(@Nullable tag: String?) {
        val mInfoDialog = PromptDialog.newInstance(
            getString(R.string.text_error_promt_title),
            getString(R.string.text_network_call_failed),
            getString(R.string.text_retry),
            getString(R.string.text_ok)
        )
        mInfoDialog.show(mFragmentManager, tag)
    }

    private fun getString(@StringRes stringId: Int): String {
        return mContext.getString(stringId)
    }
}