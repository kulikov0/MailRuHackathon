package ru.mail.mailhackathonapplication.ui.login

import dagger.Module
import dagger.Provides
import ru.mail.mailhackathonapplication.ui.login.interactor.LoginInteractor
import ru.mail.mailhackathonapplication.ui.login.interactor.LoginMvpInteractor
import ru.mail.mailhackathonapplication.ui.login.presenter.LoginMvpPresenter
import ru.mail.mailhackathonapplication.ui.login.presenter.LoginPresenter
import ru.mail.mailhackathonapplication.ui.login.view.LoginMvpView

@Module
class LoginActivityModule {

    @Provides
    fun provideLoginInteractor(interactor: LoginInteractor): LoginMvpInteractor = interactor

    @Provides
    fun provideLoginPresenter(presenter: LoginPresenter<LoginMvpView, LoginMvpInteractor>):
            LoginMvpPresenter<LoginMvpView, LoginMvpInteractor> = presenter

}