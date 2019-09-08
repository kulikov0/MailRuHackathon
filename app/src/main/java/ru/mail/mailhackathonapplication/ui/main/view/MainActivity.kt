package ru.mail.mailhackathonapplication.ui.main.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.mail.mailhackathonapplication.R
import ru.mail.mailhackathonapplication.data.network.response.GreenhouseListResponse
import ru.mail.mailhackathonapplication.ui.base.view.BaseActivity
import ru.mail.mailhackathonapplication.ui.main.interactor.MainMvpInteractor
import ru.mail.mailhackathonapplication.ui.main.presenter.MainMvpPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main), MainMvpView {

    @Inject
    lateinit var presenter: MainMvpPresenter<MainMvpView, MainMvpInteractor>

    @Inject
    lateinit var adapter: MainRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btn_add.setOnClickListener { navigator.openChooseGreenhouseScreen() }
        presenter.onAttach(this)
        presenter.getGreenHouseList()
        setupAdapter()
    }

    private fun setupAdapter() {
        recycler_view.layoutManager =  LinearLayoutManager(this)
        recycler_view.adapter = adapter
    }

    override fun addDataToRecyclerView(items: MutableList<GreenhouseListResponse.Data>) {
        adapter.addItems(items = items)
    }
}
