package ru.mail.mailhackathonapplication.ui.main.presenter

import ru.mail.mailhackathonapplication.ui.base.presenter.MvpPresenter
import ru.mail.mailhackathonapplication.ui.main.interactor.MainMvpInteractor
import ru.mail.mailhackathonapplication.ui.main.view.MainMvpView

interface MainMvpPresenter<V: MainMvpView, I: MainMvpInteractor>: MvpPresenter<V, I> {

    fun getGreenHouseList(): Any?

}