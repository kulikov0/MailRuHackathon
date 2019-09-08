package ru.mail.mailhackathonapplication.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import androidx.graphics.drawable.toDrawable
import ru.mail.mailhackathonapplication.R

object CommonUtil {

    fun showLoadingDialog(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate = true
            it.setCancelable(true)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }

}