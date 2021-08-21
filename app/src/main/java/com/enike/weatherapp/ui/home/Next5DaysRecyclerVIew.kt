package com.enike.weatherapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.enike.weatherapp.Five_days_forcast_data
import com.enike.weatherapp.R
import com.enike.weatherapp.core.BaseAdapter
import com.enike.weatherapp.core.BaseViewHolder
import com.enike.weatherapp.databinding.NextFiveDaysForcastBinding

class Next5DaysRecyclerVIew : BaseAdapter<Five_days_forcast_data>(DiffCallBack()) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =
        ForcastViewHolder.from(parent)

    override fun bind(binding: ViewDataBinding, position: Int) {
        val item = getItem(position)
        ForcastViewHolder(binding).mybind(item)
    }

    class ForcastViewHolder(val mybinding: ViewDataBinding) :
        BaseViewHolder<ViewDataBinding>(mybinding) {
        fun mybind(item: Five_days_forcast_data) {
            (mybinding as NextFiveDaysForcastBinding).data = item
        }

        companion object {
            fun from(parent: ViewGroup): ViewDataBinding {
                val view = NextFiveDaysForcastBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return view
            }
        }

    }

    class DiffCallBack() : DiffUtil.ItemCallback<Five_days_forcast_data>() {
        override fun areContentsTheSame(
            oldItem: Five_days_forcast_data,
            newItem: Five_days_forcast_data
        ): Boolean =
            oldItem == newItem

        override fun areItemsTheSame(
            oldItem: Five_days_forcast_data,
            newItem: Five_days_forcast_data
        ): Boolean =
            oldItem.day_of_week == newItem.day_of_week
    }
}

