package com.example.testing

import android.media.tv.PesRequest
import androidx.recyclerview.widget.DiffUtil

class CustomDiffUtil(val oldList:List<Person>, val newList:List<Person>): DiffUtil.Callback() {
    override fun getOldListSize(): Int  = oldList.size

    override fun getNewListSize(): Int  = newList.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return oldList[oldItemPosition].hashCode() == newList[newItemPosition].hashCode()
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}