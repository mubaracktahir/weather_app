package com.enike.weatherapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enike.weatherapp.NextFiveDaysDataClass
import com.enike.weatherapp.R
import com.enike.weatherapp.core.BaseFragment
import com.enike.weatherapp.databinding.FragmentHomeBinding
import timber.log.Timber

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun start() {
        super.start()
        initAdapter()
        binding.lifecycleOwner = this

    }


    private fun initAdapter() {

        // fake data for testing
        var data = mutableListOf(
            NextFiveDaysDataClass(" ", "Sunday", " ", "50"),
            NextFiveDaysDataClass(" ", "Monday", " ", "60"),
            NextFiveDaysDataClass(" ", "Tuesday", " ", "40"),
            NextFiveDaysDataClass(" ", "Wednesday", " ", "10"),
        )
        val adapter = Next5DaysRecyclerAdapter()
        binding.next5daysRecyclerview.adapter = adapter
        adapter.submitList(data)

    }


}