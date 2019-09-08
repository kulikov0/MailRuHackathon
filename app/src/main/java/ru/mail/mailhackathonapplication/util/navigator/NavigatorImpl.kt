package ru.mail.mailhackathonapplication.util.navigator

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import ru.mail.mailhackathonapplication.ui.choose_greenhouse.ChooseGreenhouseActivity
import ru.mail.mailhackathonapplication.ui.login.view.LoginActivity
import ru.mail.mailhackathonapplication.ui.main.view.MainActivity
import ru.mail.mailhackathonapplication.util.FileUtils
import java.io.File
import javax.inject.Inject


class NavigatorImpl @Inject constructor(val context: Context): Navigator {

    private val defaultFlag = Intent.FLAG_ACTIVITY_NEW_TASK

    override fun makeToast(toast: String) = Toast.makeText(context, toast, Toast.LENGTH_SHORT).show()

    override fun openMainScreen() = context.startActivity(Intent(context, MainActivity::class.java)
        .addFlags(defaultFlag)
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))

    override fun openLoginScreen() = context.startActivity(Intent(context, LoginActivity::class.java)
        .addFlags(defaultFlag)
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))

    override fun openChooseGreenhouseScreen() = context.startActivity(Intent(context, ChooseGreenhouseActivity::class.java)
        .addFlags(defaultFlag))
}