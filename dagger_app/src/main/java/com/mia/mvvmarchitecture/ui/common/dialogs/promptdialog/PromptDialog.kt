package com.mia.mvvvmcarchitecture.ui.common.dialogs.promptdialog

import android.app.Dialog
import android.os.Bundle
import com.mia.mvvvmcarchitecture.common.eventbus.BusDialogButtonClickEvent
import com.mia.mvvvmcarchitecture.common.eventbus.EventBus
import com.mia.mvvvmcarchitecture.ui.common.ViewFactory
import com.mia.mvvvmcarchitecture.ui.common.dialogs.BaseDialog
import javax.inject.Inject

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
class PromptDialog : BaseDialog(), PromptDialogView.Listener {

    companion object {

        private const val ARG_KEY_TITLE = "ARG_KEY_TITLE"
        private const val ARG_KEY_MESSAGE = "ARG_KEY_MESSAGE"
        private const val ARG_KEY_POSITIVE_BUTTON_TEXT = "ARG_KEY_POSITIVE_BUTTON_TEXT"
        private const val ARG_KEY_NEGATIVE_BUTTON_TEXT = "ARG_KEY_NEGATIVE_BUTTON_TEXT"

        fun newInstance(
            title: String, message: String,
            positiveButtonText: String, negativeButtonText: String
        ): PromptDialog {
            val infoDialog = PromptDialog()
            val args = Bundle()
            args.putString(ARG_KEY_TITLE, title)
            args.putString(ARG_KEY_MESSAGE, message)
            args.putString(ARG_KEY_POSITIVE_BUTTON_TEXT, positiveButtonText)
            args.putString(ARG_KEY_NEGATIVE_BUTTON_TEXT, negativeButtonText)
            infoDialog.setArguments(args)
            return infoDialog
        }
    }

    @Inject
    lateinit var mEventBus: EventBus
    @Inject
    lateinit var mViewFactory: ViewFactory
    private lateinit var mPromptDialogView: PromptDialogView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presentationComponent.inject(this)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        mPromptDialogView = mViewFactory.getPromptDialogView(null)
        setDialogValuesAndHnadleOkClickEvent()

        dialog.setContentView(mPromptDialogView.getViewBinding().root)
        return dialog
    }

    private fun setDialogValuesAndHnadleOkClickEvent() {
        mPromptDialogView.setTitle(arguments?.getString(ARG_KEY_TITLE))
        mPromptDialogView.setMessage(arguments?.getString(ARG_KEY_MESSAGE))
        mPromptDialogView.setPositiveButtonText(arguments?.getString(ARG_KEY_POSITIVE_BUTTON_TEXT))
        mPromptDialogView.setNegativeButtonText(arguments?.getString(ARG_KEY_NEGATIVE_BUTTON_TEXT))
    }

    override fun onPositiveButtonClicked() {
        dismiss()
        mEventBus.postEvent(BusDialogButtonClickEvent.POSITIVE)
    }

    override fun onNegativeButtonClicked() {
        dismiss()
        mEventBus.postEvent(BusDialogButtonClickEvent.NEGATIVE)
    }

    override fun onStart() {
        super.onStart()
        mPromptDialogView.registerLister(this)
    }

    override fun onStop() {
        super.onStop()
        mPromptDialogView.unregisterListener(this)
    }

}