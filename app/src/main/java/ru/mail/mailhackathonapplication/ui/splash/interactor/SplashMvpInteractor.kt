package ru.mail.mailhackathonapplication.ui.splash.interactor

import ru.mail.mailhackathonapplication.ui.base.interactor.MvpInteractor

interface SplashMvpInteractor: MvpInteractor {

    fun checkToken(): String?

}