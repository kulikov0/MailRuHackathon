package ru.mail.mailhackathonapplication.ui.main

import dagger.Module
import dagger.Provides
import ru.mail.mailhackathonapplication.ui.main.interactor.MainInteractor
import ru.mail.mailhackathonapplication.ui.main.interactor.MainMvpInteractor
import ru.mail.mailhackathonapplication.ui.main.presenter.MainMvpPresenter
import ru.mail.mailhackathonapplication.ui.main.presenter.MainPresenter
import ru.mail.mailhackathonapplication.ui.main.view.MainMvpView
import ru.mail.mailhackathonapplication.ui.main.view.MainRecyclerViewAdapter

@Module
class MainActivityModule {

    @Provides
    fun provideMainInteractor(interactor: MainInteractor): MainMvpInteractor = interactor

    @Provides
    fun provideMainPresenter(presenter: MainPresenter<MainMvpView, MainMvpInteractor>):
            MainMvpPresenter<MainMvpView, MainMvpInteractor> = presenter

    @Provides
    fun provideMainAdapter() = MainRecyclerViewAdapter(ArrayList())
}