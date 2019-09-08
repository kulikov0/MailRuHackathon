package ru.mail.mailhackathonapplication.util.navigator
import android.content.Intent

interface Navigator {

    fun makeToast(toast: String)
    fun openMainScreen()
    fun openLoginScreen()
    fun openChooseGreenhouseScreen()

}