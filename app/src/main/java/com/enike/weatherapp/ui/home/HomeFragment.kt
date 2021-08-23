package com.enike.weatherapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.enike.weatherapp.NextFiveDaysDataClass
import com.enike.weatherapp.R
import com.enike.weatherapp.core.BaseFragment
import com.enike.weatherapp.databinding.FragmentHomeBinding
import timber.log.Timber

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    lateinit var adapter: Next5DaysRecyclerAdapter
    override fun start() {
        super.start()
        binding.lifecycleOwner = this

        var data = mutableListOf(
            NextFiveDaysDataClass(" ", " ", " ", " "),
            NextFiveDaysDataClass(" ", " ", " ", " "),
            NextFiveDaysDataClass(" ", " ", " ", " "),
            NextFiveDaysDataClass(" ", " ", " ", " "),
        )
        initForecast(data)

        binding.next5daysRecyclerview.adapter = adapter

    }

    private fun initForecast(list: MutableList<NextFiveDaysDataClass>) {
        adapter = Next5DaysRecyclerAdapter()
    }

}