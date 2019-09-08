package ru.mail.mailhackathonapplication.ui.base.interactor

import ru.mail.mailhackathonapplication.data.network.ApiHelper
import ru.mail.mailhackathonapplication.data.preferences.PreferencesHelper

open class BaseInteractor(): MvpInteractor {

    lateinit var preferencesHelper: PreferencesHelper
    lateinit var apiHelper: ApiHelper

    constructor(preferencesHelper: PreferencesHelper, apiHelper: ApiHelper): this() {
        this.preferencesHelper = preferencesHelper
        this.apiHelper = apiHelper
    }
}