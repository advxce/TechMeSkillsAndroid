package com.example.testing.task6.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ListMargin(private val paddingVertical:Int):RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val lastElem = (parent.adapter?.itemCount ?: 0) -1
        outRect.set(0, 0, 0, 0)

        if( position != lastElem){
            outRect.bottom = paddingVertical
        }

    }



}