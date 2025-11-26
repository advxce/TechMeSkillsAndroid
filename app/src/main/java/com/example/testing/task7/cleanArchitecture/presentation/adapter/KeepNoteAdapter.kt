package com.example.testing.task7.cleanArchitecture.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.RecAdapter
import com.example.testing.databinding.ItemKeepNoteBinding
import com.example.testing.task7.cleanArchitecture.presentation.entity.KeepNoteUI

class KeepNoteAdapter(
    private val onDelete: (KeepNoteUI)-> Unit,
    private val onEdit:(KeepNoteUI)->Unit,
): ListAdapter<KeepNoteUI, RecyclerView.ViewHolder>(KeepDiffUtil()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val item = ItemKeepNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KeepNoteViewHolder(item)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int

    ) {
        (holder as KeepNoteViewHolder).bind(getItem(position))
    }


    inner class KeepNoteViewHolder(private val binding: ItemKeepNoteBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(note: KeepNoteUI){
            binding.title.text = note.title
            binding.description.text = note.description
            binding.data.text = note.date
            binding.deleteBtn.setOnClickListener {

            }
            binding.editBtn.setOnClickListener {
                onEdit(note)
            }
            binding.deleteBtn.setOnClickListener {
                onDelete(note)
            }
        }
    }

}