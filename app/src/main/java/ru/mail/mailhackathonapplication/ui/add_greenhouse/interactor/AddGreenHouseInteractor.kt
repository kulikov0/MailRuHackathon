package ru.mail.mailhackathonapplication.ui.add_greenhouse.interactor

import ru.mail.mailhackathonapplication.data.network.ApiHelper
import ru.mail.mailhackathonapplication.data.preferences.PreferencesHelper
import ru.mail.mailhackathonapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class AddGreenHouseInteractor @Inject constructor(apiHelper: ApiHelper, preferencesHelper: PreferencesHelper):
        BaseInteractor(apiHelper = apiHelper, preferencesHelper = preferencesHelper), AddGreenHouseMvpInteractor {

}