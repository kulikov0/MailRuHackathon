package ru.mail.mailhackathonapplication.ui.login.view

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import ru.mail.mailhackathonapplication.R
import ru.mail.mailhackathonapplication.ui.base.view.BaseActivity
import ru.mail.mailhackathonapplication.ui.login.interactor.LoginMvpInteractor
import ru.mail.mailhackathonapplication.ui.login.presenter.LoginMvpPresenter
import javax.inject.Inject

class LoginActivity: BaseActivity(R.layout.activity_login), LoginMvpView {

    @Inject
    lateinit var presenter: LoginMvpPresenter<LoginMvpView, LoginMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        setSupportActionBar(toolbar)
        btn_login.setOnClickListener {
        //    presenter.doServerLogin(login = input_email.text.toString(), password = input_password.text.toString())
            openMainScreen()
        }
    }

    override fun openMainScreen() = navigator.openMainScreen()

}