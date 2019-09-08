package ru.mail.mailhackathonapplication.ui.main.presenter

import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import ru.mail.mailhackathonapplication.data.network.response.GreenhouseListResponse
import ru.mail.mailhackathonapplication.ui.base.presenter.BasePresenter
import ru.mail.mailhackathonapplication.ui.main.interactor.MainMvpInteractor
import ru.mail.mailhackathonapplication.ui.main.view.MainMvpView
import ru.mail.mailhackathonapplication.util.AppConstants
import ru.mail.mailhackathonapplication.util.SchedulerProvider
import java.net.ConnectException
import javax.inject.Inject

class MainPresenter<V: MainMvpView, I: MainMvpInteractor> @Inject constructor(interactor: I,
                                                                              schedulerProvider: SchedulerProvider,
                                                                              disposable: CompositeDisposable):
        BasePresenter<V,I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    MainMvpPresenter<V, I> {

    override fun getGreenHouseList(): Any? = getView()?.let {view ->
        interactor?.let {
            view.addDataToRecyclerView(it.getGreenhouseList())
        }
    }

}