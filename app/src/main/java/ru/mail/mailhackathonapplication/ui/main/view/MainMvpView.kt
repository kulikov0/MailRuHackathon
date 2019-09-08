package ru.mail.mailhackathonapplication.ui.main.view

import ru.mail.mailhackathonapplication.data.network.response.GreenhouseListResponse
import ru.mail.mailhackathonapplication.ui.base.view.MvpView

interface MainMvpView: MvpView {

    fun addDataToRecyclerView(items: MutableList<GreenhouseListResponse.Data>)

}