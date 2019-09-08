package ru.mail.mailhackathonapplication.ui.splash.presenter

import ru.mail.mailhackathonapplication.ui.base.presenter.MvpPresenter
import ru.mail.mailhackathonapplication.ui.splash.interactor.SplashMvpInteractor
import ru.mail.mailhackathonapplication.ui.splash.view.SplashMvpView

interface SplashMvpPresenter<V: SplashMvpView, I: SplashMvpInteractor>: MvpPresenter<V, I> {

    fun checkToken(): Any?

}