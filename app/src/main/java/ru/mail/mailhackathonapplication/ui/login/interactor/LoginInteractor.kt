package ru.mail.mailhackathonapplication.ui.login.interactor

import io.reactivex.Observable
import ru.mail.mailhackathonapplication.data.network.ApiHelper
import ru.mail.mailhackathonapplication.data.network.response.LoginResponse
import ru.mail.mailhackathonapplication.data.preferences.PreferencesHelper
import ru.mail.mailhackathonapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class LoginInteractor @Inject constructor(preferencesHelper: PreferencesHelper, apiHelper: ApiHelper):
        BaseInteractor(preferencesHelper = preferencesHelper, apiHelper = apiHelper), LoginMvpInteractor {

    override fun doServerLogin(login: String, password: String): Observable<LoginResponse> {
        return apiHelper.doUserLogin(login = login, password = password)
    }

    override fun saveAccessToken(accessToken: String?) = preferencesHelper.setAccessTokenFromServer(accessToken = accessToken)

}