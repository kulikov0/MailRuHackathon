package ru.mail.mailhackathonapplication.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import ru.mail.mailhackathonapplication.util.CommonUtil
import ru.mail.mailhackathonapplication.util.navigator.Navigator
import javax.inject.Inject


abstract class BaseActivity(open var layout_id: Int): AppCompatActivity(), MvpView{

    @Inject
    lateinit var navigator: Navigator

    private var progressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout_id)
        performDI()
    }

    private fun performDI() = AndroidInjection.inject(this)

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

}