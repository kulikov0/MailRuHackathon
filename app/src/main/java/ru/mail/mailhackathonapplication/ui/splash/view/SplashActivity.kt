package ru.mail.mailhackathonapplication.ui.splash.view

import android.animation.Animator
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_splash.*
import ru.mail.mailhackathonapplication.R
import ru.mail.mailhackathonapplication.ui.base.view.BaseActivity
import ru.mail.mailhackathonapplication.ui.splash.interactor.SplashMvpInteractor
import ru.mail.mailhackathonapplication.ui.splash.presenter.SplashMvpPresenter
import yanzhikai.textpath.PathAnimatorListener
import javax.inject.Inject

class SplashActivity: BaseActivity(R.layout.activity_splash), SplashMvpView {

    @Inject
    lateinit var presenter: SplashMvpPresenter<SplashMvpView, SplashMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        tv_animated.apply {
            startAnimation(0f, 1f)
            setAnimatorListener(object: PathAnimatorListener() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    presenter.checkToken()
                }
            })
        }

    }

    override fun openLoginScreen() = navigator.openLoginScreen()

    override fun openMainScreen() = navigator.openMainScreen()

}