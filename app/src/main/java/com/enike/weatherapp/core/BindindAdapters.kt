package com.enike.weatherapp.core

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:weather_temperature")
fun setTemperature(view: TextView, data: String) {
    view.text = data
}

@BindingAdapter("app:set_day_of_week")
fun setDayOfWeek(view: TextView, data: String) {
    view.text = data
}