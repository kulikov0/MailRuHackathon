package ru.mail.mailhackathonapplication.ui.add_greenhouse.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_greenhouse.*
import ru.mail.mailhackathonapplication.R
import ru.mail.mailhackathonapplication.ui.add_greenhouse.interactor.AddGreenHouseMvpInteractor
import ru.mail.mailhackathonapplication.ui.add_greenhouse.presenter.AddGreenHouseMvpPresenter
import ru.mail.mailhackathonapplication.ui.base.view.BaseActivity
import javax.inject.Inject

class AddGreenHouseActivity: BaseActivity(R.layout.activity_add_greenhouse), AddGreenHouseMvpView {

    @Inject
    lateinit var presenter: AddGreenHouseMvpPresenter<AddGreenHouseMvpView, AddGreenHouseMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        text_distance.text = "0ч."
        btn_save.setOnClickListener {
            Toast.makeText(this, "Устройство сохранено и скоро появится в списке", Toast.LENGTH_SHORT).show()
            navigator.openMainScreen()
        }

        seekbar_distance.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                text_distance.text = "${progress}ч."
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

}