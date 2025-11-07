package com.example.testing.architectures.MVC

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.ItemUserMvcBinding

class UserMVCAdapter(
    var userList:List<User>,
    val onDelete:(User)-> Unit
): RecyclerView.Adapter<UserMVCAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val item = ItemUserMvcBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return CustomViewHolder(item)
    }

    override fun onBindViewHolder(
        holder: CustomViewHolder,
        position: Int
    ) {
        holder.bind(userList[position])
    }

    fun updateUsers(users:List<User>): List<User>{
        notifyDataSetChanged()
        userList = users
        return userList
    }

    override fun getItemCount(): Int = userList.size

    inner class CustomViewHolder(val binding: ItemUserMvcBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user:User)=with(binding){
            userId.text = user.id.toString()
            userName.text = user.name
            btnDelete.setOnClickListener { onDelete(user) }
        }
    }
}