package com.example.testing.task5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.ListItemTask5Binding

class Task5RecViewAdapter(private val infoTextView: View): RecyclerView.Adapter<Task5RecViewAdapter.MyViewHolder>() {
    var userList = listOf<UserDataTask5>()



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val item = ListItemTask5Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.bind(userList[position])
    }

    fun addUser(newList: List<UserDataTask5>){
        userList = newList
        notifyDataSetChanged()
        if(userList.isEmpty()){
            infoTextView.visibility = View.VISIBLE
        }
        else{
            infoTextView.visibility = View.GONE
        }
    }



    override fun getItemCount(): Int = userList.size

    inner class MyViewHolder(val binding: ListItemTask5Binding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: UserDataTask5){

            binding.tvUserId.text = item.id.toString()
            binding.tvUserName.text = item.name.toString()
        }
    }

}