package ru.mail.mailhackathonapplication.ui.base.presenter

import ru.mail.mailhackathonapplication.ui.base.interactor.MvpInteractor
import ru.mail.mailhackathonapplication.ui.base.view.MvpView

interface MvpPresenter<V: MvpView, I: MvpInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}