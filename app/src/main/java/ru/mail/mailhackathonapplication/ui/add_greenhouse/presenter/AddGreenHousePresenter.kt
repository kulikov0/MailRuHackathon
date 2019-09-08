package ru.mail.mailhackathonapplication.ui.add_greenhouse.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.mail.mailhackathonapplication.ui.add_greenhouse.interactor.AddGreenHouseInteractor
import ru.mail.mailhackathonapplication.ui.add_greenhouse.interactor.AddGreenHouseMvpInteractor
import ru.mail.mailhackathonapplication.ui.add_greenhouse.view.AddGreenHouseMvpView
import ru.mail.mailhackathonapplication.ui.base.presenter.BasePresenter
import ru.mail.mailhackathonapplication.util.SchedulerProvider
import javax.inject.Inject

class AddGreenHousePresenter<V: AddGreenHouseMvpView, I: AddGreenHouseMvpInteractor> @Inject constructor(interactor: I,
                                                                                                         schedulerProvider: SchedulerProvider,
                                                                                                         disposable: CompositeDisposable):
        BasePresenter<V,I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        AddGreenHouseMvpPresenter<V, I>