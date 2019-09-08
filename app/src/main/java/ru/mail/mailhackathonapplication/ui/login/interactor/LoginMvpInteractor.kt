package ru.mail.mailhackathonapplication.ui.login.interactor

import io.reactivex.Observable
import ru.mail.mailhackathonapplication.data.network.response.LoginResponse
import ru.mail.mailhackathonapplication.ui.base.interactor.MvpInteractor

interface LoginMvpInteractor: MvpInteractor {

    fun doServerLogin(login: String, password: String): Observable<LoginResponse>
    fun saveAccessToken(accessToken: String?)

}