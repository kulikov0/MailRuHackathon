package ru.mail.mailhackathonapplication.ui.choose_greenhouse

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_choose_greenhouse.*
import ru.mail.mailhackathonapplication.R
import ru.mail.mailhackathonapplication.ui.add_greenhouse.view.AddGreenHouseActivity

class ChooseGreenhouseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_greenhouse)
        layout_multichoice.setOnClickListener { startActivity(Intent(this, AddGreenHouseActivity::class.java)) }
    }

}