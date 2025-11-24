package com.example.testing.task6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.ItemAuthorTask6Binding
import com.example.testing.databinding.ItemButtonTask6Binding
import com.example.testing.databinding.ItemImageTask6Binding

import com.example.testing.task6.entity.Entities

class MyListAdapter: ListAdapter<Entities, RecyclerView.ViewHolder>(MyDiffUtilItem()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when(viewType){
           TYPE_PICTURE_WITH_TXT -> {
                val item = ItemImageTask6Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                PictureViewHolder(item)
            }
            TYPE_BUTTON_WITH_TXT -> {
                val item = ItemButtonTask6Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                ButtonViewHolder(item)
            }
            TYPE_AUTHOR_WITH_TXT -> {
                val item = ItemAuthorTask6Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                AuthorViewHolder(item)
            }
            else -> throw IllegalArgumentException("no type")
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when(holder){
            is AuthorViewHolder -> holder.onBind(getItem(position) as Entities.AuthorData)
            is ButtonViewHolder -> holder.onBind(getItem(position) as Entities.ButtonData)
            is PictureViewHolder -> holder.onBind(getItem(position)  as Entities.PictureData)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)){
            is Entities.AuthorData -> TYPE_AUTHOR_WITH_TXT
            is Entities.ButtonData -> TYPE_BUTTON_WITH_TXT
            is Entities.PictureData -> TYPE_PICTURE_WITH_TXT
            else -> throw IllegalArgumentException("unknown type")
        }
    }
    inner class AuthorViewHolder(val binding: ItemAuthorTask6Binding): RecyclerView.ViewHolder(binding.root){
        fun onBind(author: Entities.AuthorData){
            binding.authorName.text = author.name
            binding.authorDescription.text = author.text
        }
    }

    inner class ButtonViewHolder(val binding: ItemButtonTask6Binding): RecyclerView.ViewHolder(binding.root){
        fun onBind(button: Entities.ButtonData){
            binding.authorDescription.text = button.text
        }
    }

    inner class PictureViewHolder(val binding: ItemImageTask6Binding): RecyclerView.ViewHolder(binding.root){
        fun onBind(picture: Entities.PictureData){
            binding.image.setImageResource(picture.picture)
            binding.imageDescription.text = picture.text
        }
    }


    companion object{
        private const val TYPE_AUTHOR_WITH_TXT = 0
        private const val TYPE_PICTURE_WITH_TXT = 1
        private const val TYPE_BUTTON_WITH_TXT = 2
    }
}