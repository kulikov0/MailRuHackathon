package ru.mail.mailhackathonapplication.util.errors_handler

import android.content.Context
import android.widget.Toast
import ru.mail.mailhackathonapplication.data.preferences.PreferencesHelper
import ru.mail.mailhackathonapplication.util.AppConstants
import ru.mail.mailhackathonapplication.util.navigator.Navigator
import javax.inject.Inject

class ErrorsHandlerImpl @Inject constructor(val context: Context, val preferencesHelper: PreferencesHelper,
                                            val navigator: Navigator): ErrorsHandler {

    override fun handleError(error: Int?, httpErrorCode: Int?) {
        when (error) {
            AppConstants.NO_INTERNET_ERROR              -> makeToast("Нет интернета")
            AppConstants.SERVER_ERROR                   -> makeToast("Ошибка сервера", httpErrorCode)
            else                                        -> throw IllegalArgumentException("Unsupported error code $error")
        }
    }

    private fun makeToast(message: String, code: Int? = null) {
        Toast.makeText(context, if (code == null) message
        else "$message $code", Toast.LENGTH_SHORT).show()
    }

}