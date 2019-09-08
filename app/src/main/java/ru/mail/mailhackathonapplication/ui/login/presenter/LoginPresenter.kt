package ru.mail.mailhackathonapplication.ui.login.presenter

import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import ru.mail.mailhackathonapplication.data.network.response.LoginResponse
import ru.mail.mailhackathonapplication.ui.base.presenter.BasePresenter
import ru.mail.mailhackathonapplication.ui.login.interactor.LoginMvpInteractor
import ru.mail.mailhackathonapplication.ui.login.view.LoginMvpView
import ru.mail.mailhackathonapplication.util.AppConstants
import ru.mail.mailhackathonapplication.util.SchedulerProvider
import java.net.ConnectException
import javax.inject.Inject

class LoginPresenter<V: LoginMvpView, I: LoginMvpInteractor> @Inject constructor(interactor: I,
                                                                                 schedulerProvider: SchedulerProvider,
                                                                                 disposable: CompositeDisposable):
        BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        LoginMvpPresenter<V, I> {

    override fun doServerLogin(login: String, password: String): Any? = getView()?.let { view ->
        view.showProgress()
        interactor?.let {
            compositeDisposable.add(it.doServerLogin(login = login, password = password)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ response ->
                    when (response) {
                        is LoginResponse.Success -> {
                            view.hideProgress()
                            it.saveAccessToken(response.token)
                            view.openMainScreen()
                        }
                        is LoginResponse.Error -> {
                            view.hideProgress()
                        }
                     }
                }, {error -> when(error) {
                    is ConnectException -> errorsHandler.handleError(AppConstants.NO_INTERNET_ERROR)
                    is HttpException    -> errorsHandler.handleError(AppConstants.SERVER_ERROR, error.code())
                } }))
        }
    }

}