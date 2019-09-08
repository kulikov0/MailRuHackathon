package ru.mail.mailhackathonapplication.ui.add_greenhouse

import dagger.Module
import dagger.Provides
import ru.mail.mailhackathonapplication.ui.add_greenhouse.interactor.AddGreenHouseInteractor
import ru.mail.mailhackathonapplication.ui.add_greenhouse.interactor.AddGreenHouseMvpInteractor
import ru.mail.mailhackathonapplication.ui.add_greenhouse.presenter.AddGreenHouseMvpPresenter
import ru.mail.mailhackathonapplication.ui.add_greenhouse.presenter.AddGreenHousePresenter
import ru.mail.mailhackathonapplication.ui.add_greenhouse.view.AddGreenHouseMvpView

@Module
class AddGreenHouseActivityModule {

    @Provides
    fun providesAddGreenHouseInteractor(interactor: AddGreenHouseInteractor): AddGreenHouseMvpInteractor = interactor

    @Provides
    fun providesAddGreenHousePresenter(presenter: AddGreenHousePresenter<AddGreenHouseMvpView, AddGreenHouseMvpInteractor>):
            AddGreenHouseMvpPresenter<AddGreenHouseMvpView, AddGreenHouseMvpInteractor> = presenter

}