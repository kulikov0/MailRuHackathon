package ru.mail.mailhackathonapplication.ui.splash.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.mail.mailhackathonapplication.ui.base.presenter.BasePresenter
import ru.mail.mailhackathonapplication.ui.splash.interactor.SplashMvpInteractor
import ru.mail.mailhackathonapplication.ui.splash.view.SplashMvpView
import ru.mail.mailhackathonapplication.util.SchedulerProvider
import javax.inject.Inject

class SplashPresenter<V: SplashMvpView, I: SplashMvpInteractor> @Inject constructor(interactor: I,
                                                                                    schedulerProvider: SchedulerProvider,
                                                                                    disposable: CompositeDisposable):
        BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        SplashMvpPresenter<V, I> {

    override fun checkToken(): Any? = getView()?.let { view ->

        interactor?.let {
            when (it.checkToken().isNullOrEmpty()) {
                false -> view.openMainScreen()
                true  -> view.openLoginScreen()
            }
        }

    }
}