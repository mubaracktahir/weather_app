package com.enike.weatherapp.core

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T>(callback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseViewHolder<ViewDataBinding>>(callback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        getViewHolder(parent, viewType)

    open fun getViewHolder(parent: ViewGroup, viewType: Int) =
        BaseViewHolder(createBinding(parent, viewType))

    abstract fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        (holder as BaseViewHolder<*>).binding.root
        bind(holder.binding, position)
    }

    abstract fun bind(binding: ViewDataBinding, position: Int)

}
