package com.example.testing.myTestingLesson

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.ListItemBinding

class MyCustomAdapter(val list:List<String>): RecyclerView.Adapter<MyCustomAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val itemView = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: CustomViewHolder,
        position: Int
    ) {
        holder.bind(list[position])

    }



    override fun getItemCount(): Int = list.size

    inner class CustomViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(listItem: String){
            binding.tvItem.text = listItem
            binding.listItem.setOnClickListener {
                Log.i("ItemClick", "${it}")
            }
        }



    }

}