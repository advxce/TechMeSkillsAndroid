package com.example.testing.task7.cleanArchitecture.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testing.task7.cleanArchitecture.presentation.entity.KeepNoteUI

class KeepDiffUtil: DiffUtil.ItemCallback<KeepNoteUI>() {
    override fun areItemsTheSame(
        oldItem: KeepNoteUI,
        newItem: KeepNoteUI
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(
        oldItem: KeepNoteUI,
        newItem: KeepNoteUI
    ): Boolean {
        return oldItem == newItem
    }
}