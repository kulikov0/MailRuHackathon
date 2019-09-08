package ru.mail.mailhackathonapplication.ui.main.view

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_greenhouse.view.*
import ru.mail.mailhackathonapplication.R
import ru.mail.mailhackathonapplication.data.network.response.GreenhouseListResponse
import java.text.SimpleDateFormat
import java.util.*

class MainRecyclerViewAdapter(private val items: MutableList<GreenhouseListResponse.Data>):
    RecyclerView.Adapter<MainRecyclerViewAdapter.MainRecyclerViewHolder>() {

    fun addItems(items: MutableList<GreenhouseListResponse.Data>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MainRecyclerViewHolder =
        MainRecyclerViewHolder(LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.item_greenhouse, viewGroup, false))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) = holder.onBind(position)

    inner class MainRecyclerViewHolder(view: View): RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n", "SimpleDateFormat")
        fun onBind(position: Int) {
            itemView.apply {
                tv_last_update.text = "Обновлено ${SimpleDateFormat("HH:mm:ss").format(Date())}"
                tv_greenhouse_group.text = items[position].groupName
                tv_greenhouse_type.text = items[position].groupType
                tv_humid.text = "${items[position].humidValue}%"
                tv_water_temp.text = "${items[position].waterTempValue}°C"
                ground_humid.text = "${items[position].groundHumidValue}%"
                tv_air_temp.text = "${items[position].airTempValue}°C"
            }
        }

    }

}