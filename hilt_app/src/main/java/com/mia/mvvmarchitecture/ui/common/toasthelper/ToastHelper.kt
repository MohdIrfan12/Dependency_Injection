package com.mia.mvvvmcarchitecture.ui.common.toasthelper

import android.app.Application
import android.widget.Toast
import com.mia.mvvmarchitecture.R
import javax.inject.Inject

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class ToastHelper @Inject constructor(private val mContext: Application) {

    fun showUsecaseError() {
        Toast.makeText(mContext, R.string.text_network_call_failed, Toast.LENGTH_SHORT).show()
    }

    fun showPremissionGrantedMsg() {
        Toast.makeText(mContext, R.string.text_permission_granted, Toast.LENGTH_SHORT).show()
    }

    fun showDeclinedMsg() {
        Toast.makeText(mContext, R.string.text_permission_declined, Toast.LENGTH_SHORT).show()
    }

    fun showPermissionDeclinedCantAskMoreMsg() {
        Toast.makeText(mContext, R.string.text_permission_declined_and_can_not_ask_more, Toast.LENGTH_SHORT).show()
    }
}