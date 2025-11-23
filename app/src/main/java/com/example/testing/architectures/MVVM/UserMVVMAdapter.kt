package com.example.testing.architectures.MVVM

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.UserItemMvvmBinding

class UserMVVMAdapter(
    val onDeleteUser:(UserMVVM)-> Unit
): RecyclerView.Adapter<UserMVVMAdapter.MyCustomViewHolder>() {

    private var userList: List<UserMVVM> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCustomViewHolder {
        val item = UserItemMvvmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyCustomViewHolder(item)
    }

    override fun onBindViewHolder(
        holder: MyCustomViewHolder,
        position: Int
    ) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    fun addUserMVVM(newUserList: List<UserMVVM>){
        userList = newUserList
        notifyDataSetChanged()
    }

    inner class MyCustomViewHolder(val binding: UserItemMvvmBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: UserMVVM){
            binding.userId.text = item.id.toString()
            binding.userName.text = item.name

            binding.btnDelete.setOnClickListener {
                onDeleteUser(item)
            }
        }
    }
}