package ru.mail.mailhackathonapplication.ui.base.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.mail.mailhackathonapplication.ui.base.interactor.MvpInteractor
import ru.mail.mailhackathonapplication.ui.base.view.MvpView
import ru.mail.mailhackathonapplication.util.SchedulerProvider
import ru.mail.mailhackathonapplication.util.errors_handler.ErrorsHandler

import javax.inject.Inject

abstract class BasePresenter<V: MvpView, I: MvpInteractor> internal constructor(protected var interactor: I?,
                                                                                protected var schedulerProvider: SchedulerProvider,
                                                                                protected val compositeDisposable: CompositeDisposable):
    MvpPresenter<V, I> {

    @Inject
    lateinit var errorsHandler: ErrorsHandler

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.clear()
        view?.hideProgress()
        view = null
    }

}