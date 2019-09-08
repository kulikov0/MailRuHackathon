package ru.mail.mailhackathonapplication.ui.login.presenter

import ru.mail.mailhackathonapplication.ui.base.presenter.MvpPresenter
import ru.mail.mailhackathonapplication.ui.login.interactor.LoginMvpInteractor
import ru.mail.mailhackathonapplication.ui.login.view.LoginMvpView

interface LoginMvpPresenter<V: LoginMvpView, I: LoginMvpInteractor>: MvpPresenter<V,I> {

    fun doServerLogin(login: String, password: String): Any?

}