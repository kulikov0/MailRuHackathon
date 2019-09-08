package ru.mail.mailhackathonapplication.ui.splash

import dagger.Module
import dagger.Provides
import ru.mail.mailhackathonapplication.ui.splash.interactor.SplashInteractor
import ru.mail.mailhackathonapplication.ui.splash.interactor.SplashMvpInteractor
import ru.mail.mailhackathonapplication.ui.splash.presenter.SplashMvpPresenter
import ru.mail.mailhackathonapplication.ui.splash.presenter.SplashPresenter
import ru.mail.mailhackathonapplication.ui.splash.view.SplashMvpView

@Module
class SplashActivityModule {

    @Provides
    fun providesSplashInteractor(interactor: SplashInteractor): SplashMvpInteractor = interactor

    @Provides
    fun providesSplashPresenter(presenter: SplashPresenter<SplashMvpView, SplashMvpInteractor>):
            SplashMvpPresenter<SplashMvpView, SplashMvpInteractor> = presenter

}