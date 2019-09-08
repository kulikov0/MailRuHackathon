package ru.mail.mailhackathonapplication.ui.main.interactor

import io.reactivex.Observable
import ru.mail.mailhackathonapplication.data.network.response.GreenhouseListResponse
import ru.mail.mailhackathonapplication.ui.base.interactor.MvpInteractor

interface MainMvpInteractor: MvpInteractor {

    fun getGreenhouseList(): MutableList<GreenhouseListResponse.Data>

}