package ru.mail.mailhackathonapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.mail.mailhackathonapplication.ui.add_greenhouse.AddGreenHouseActivityModule
import ru.mail.mailhackathonapplication.ui.add_greenhouse.view.AddGreenHouseActivity
import ru.mail.mailhackathonapplication.ui.login.LoginActivityModule
import ru.mail.mailhackathonapplication.ui.login.view.LoginActivity
import ru.mail.mailhackathonapplication.ui.main.MainActivityModule
import ru.mail.mailhackathonapplication.ui.main.view.MainActivity
import ru.mail.mailhackathonapplication.ui.splash.SplashActivityModule
import ru.mail.mailhackathonapplication.ui.splash.view.SplashActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [AddGreenHouseActivityModule::class])
    abstract fun bindAddGreenHouseActivity(): AddGreenHouseActivity
}