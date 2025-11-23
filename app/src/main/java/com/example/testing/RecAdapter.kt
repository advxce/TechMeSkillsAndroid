package com.example.testing

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.PersonItenBinding

class RecAdapter(
    private var list: List<Person>,

    ) : RecyclerView.Adapter<RecAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val item = PersonItenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.bind(list[position])


    }


    fun returnDefaultList(): List<Person> {
        val defaultList = list

        return defaultList
    }


    fun update(newList:List<Person>){
        list = newList
        notifyDataSetChanged()
    }

    fun addRandNum(testList:List<Person>) {
        val newList =  list.map{
            it.copy(name =  it.name+(1..10).random())
        }.toMutableList()




        val state = DiffUtil.calculateDiff(CustomDiffUtil(oldList = list, newList= newList))

        list = newList

        state.dispatchUpdatesTo(this)

    }

    override fun getItemCount(): Int = list.size

    inner class MyViewHolder(val binding: PersonItenBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {

//            binding.rating.text = (person.rating + 0.01).toString()
            binding.name.text = person.name
//            binding.root.setOnClickListener {
//                binding.rating.text = (person.rating + 0.01).toString()
//                Log.i("Tag", "${person.hashCode()}")
//            }
//
//            binding.addRandNum.setOnClickListener {
//                binding.name.text = (person.name + (1..10).random()).toString()
//
//            }


        }


    }
}