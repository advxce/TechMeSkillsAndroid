package com.example.testing.architectures.MVP

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.ItemUserMvpBinding

class UserMVPAdapter(
    var users:List<User>,
    val onDelete:(User)-> Unit
): RecyclerView.Adapter<UserMVPAdapter.MyCustomViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCustomViewHolder {
        val item = ItemUserMvpBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyCustomViewHolder(item)
    }

    override fun onBindViewHolder(
        holder: MyCustomViewHolder,
        position: Int
    ) {
        holder.bind(users[position])
    }

    fun updateUsers(newUsers:List<User>): List<User>{

        users = newUsers
        notifyDataSetChanged()
        return users
    }

    override fun getItemCount(): Int = users.size

    inner class MyCustomViewHolder(val binding: ItemUserMvpBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.userId.text = user.id.toString()
            binding.userName.text = user.name
            binding.btnDelete.setOnClickListener {
                onDelete(user)
            }
        }
    }
}