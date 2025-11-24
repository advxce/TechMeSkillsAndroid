package com.example.testing.task6.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testing.task6.entity.Entities

class MyDiffUtilItem: DiffUtil.ItemCallback<Entities>() {
    override fun areItemsTheSame(
        oldItem: Entities,
        newItem: Entities
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(
        oldItem: Entities,
        newItem: Entities
    ): Boolean {
        return oldItem == newItem
    }

}