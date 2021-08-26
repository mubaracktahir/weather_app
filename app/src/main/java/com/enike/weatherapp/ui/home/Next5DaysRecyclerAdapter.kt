package com.enike.weatherapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.enike.weatherapp.NextFiveDaysDataClass
import com.enike.weatherapp.core.BaseAdapter
import com.enike.weatherapp.core.BaseViewHolder
import com.enike.weatherapp.databinding.NextFiveDaysForcastBinding

class Next5DaysRecyclerAdapter() : BaseAdapter<NextFiveDaysDataClass>(DiffCallBack()) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =
        ForcastViewHolder.from(parent)

    override fun bind(binding: ViewDataBinding, position: Int) {
        val item = getItem(position)
        ForcastViewHolder(binding).mybind(item)
        binding.executePendingBindings()
    }

    class ForcastViewHolder(val mybinding: ViewDataBinding) :
        BaseViewHolder<ViewDataBinding>(mybinding) {
        fun mybind(item: NextFiveDaysDataClass) {
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

    class DiffCallBack() : DiffUtil.ItemCallback<NextFiveDaysDataClass>() {
        override fun areContentsTheSame(
            oldItem: NextFiveDaysDataClass,
            newItem: NextFiveDaysDataClass
        ): Boolean = oldItem == newItem

        override fun areItemsTheSame(
            oldItem: NextFiveDaysDataClass,
            newItem: NextFiveDaysDataClass
        ): Boolean = oldItem.day_of_week == newItem.day_of_week
    }
}

