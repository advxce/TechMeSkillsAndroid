package com.example.testing.task6.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.ItemAuthorTask6Binding
import com.example.testing.databinding.ItemButtonTask6Binding
import com.example.testing.databinding.ItemImageTask6Binding
import com.example.testing.task6.entity.AuthorData
import com.example.testing.task6.entity.ButtonData
import com.example.testing.task6.entity.Entities
import com.example.testing.task6.entity.PictureData

class MultiTypeAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var list: List<Any> = mutableListOf()

    override fun getItemViewType(position: Int): Int {
        return when(list[position]){
            is AuthorData -> TYPE_AUTHOR_WITH_TXT
            is ButtonData -> TYPE_BUTTON_WITH_TXT
            is PictureData -> TYPE_PICTURE_WITH_TXT
            else -> throw IllegalArgumentException("unknown type")
        }
    }

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

    fun load(newList:List<Any>){
        list = newList
    }

    fun update(element:Any){
        val newList: MutableList<Any> = mutableListOf()
        newList.addAll(list)
        newList.add(element)
        Log.i("TAG", "list " + list.toString())
        val diffUtil = DiffUtil.calculateDiff(MyDiffUtil(list,newList))
        list = newList
        diffUtil.dispatchUpdatesTo(this)

        Log.i("TAG", "newlist "+newList.toString())

    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when(holder){
            is AuthorViewHolder -> holder.bind(list[position] as AuthorData)
            is ButtonViewHolder -> holder.bind(list[position] as ButtonData)
            is PictureViewHolder -> holder.bind(list[position] as PictureData)
        }
    }

    inner class AuthorViewHolder(val binding: ItemAuthorTask6Binding): RecyclerView.ViewHolder(binding.root){
        fun bind(author: AuthorData){
            binding.authorName.text = author.name
            binding.authorDescription.text = author.text
        }
    }

    inner class ButtonViewHolder(val binding: ItemButtonTask6Binding): RecyclerView.ViewHolder(binding.root){
        fun bind(button: ButtonData){
            binding.authorDescription.text = button.text
        }
    }

    inner class PictureViewHolder(val binding: ItemImageTask6Binding): RecyclerView.ViewHolder(binding.root){
        fun bind(picture: PictureData){
            binding.image.setImageResource(picture.picture)
            binding.imageDescription.text = picture.text
        }
    }

    override fun getItemCount(): Int = list.size

    companion object{
        private const val TYPE_AUTHOR_WITH_TXT = 0
        private const val TYPE_PICTURE_WITH_TXT = 1
        private const val TYPE_BUTTON_WITH_TXT = 2
    }

}