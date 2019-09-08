package ru.mail.mailhackathonapplication.ui.add_greenhouse.presenter

import ru.mail.mailhackathonapplication.ui.add_greenhouse.interactor.AddGreenHouseMvpInteractor
import ru.mail.mailhackathonapplication.ui.add_greenhouse.view.AddGreenHouseMvpView
import ru.mail.mailhackathonapplication.ui.base.presenter.MvpPresenter

interface AddGreenHouseMvpPresenter<V: AddGreenHouseMvpView, I: AddGreenHouseMvpInteractor>: MvpPresenter<V,I>