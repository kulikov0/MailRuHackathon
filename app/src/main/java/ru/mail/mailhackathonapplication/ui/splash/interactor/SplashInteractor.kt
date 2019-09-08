package ru.mail.mailhackathonapplication.ui.splash.interactor

import ru.mail.mailhackathonapplication.data.network.ApiHelper
import ru.mail.mailhackathonapplication.data.preferences.PreferencesHelper
import ru.mail.mailhackathonapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class SplashInteractor @Inject constructor(apiHelper: ApiHelper, preferencesHelper: PreferencesHelper):
        BaseInteractor(apiHelper = apiHelper, preferencesHelper = preferencesHelper), SplashMvpInteractor {

    override fun checkToken(): String? = preferencesHelper.getAccessToken()

}