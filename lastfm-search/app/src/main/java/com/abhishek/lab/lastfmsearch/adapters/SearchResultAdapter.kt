package com.abhishek.lab.lastfmsearch.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.lab.lastfmsearch.R
import com.abhishek.lab.lastfmsearch.adapters.viewholders.BaseViewHolder

/**
 *
 * Created by  Abhishek Pathak on 17-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
class SearchResultAdapter(
    val context: Context,
    private var items: List<ListItem>,
    private val listener: ListClickListener<View, ListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateData(newItems: List<ListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {

        return when (items[position]) {
            is ListItemHeader -> ListItem.Type.HEADER.ordinal
            else -> ListItem.Type.RESULT.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == ListItem.Type.HEADER.ordinal)
            HeaderViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.row_header,
                    parent,
                    false
                )
            )
        else
            SearchResultViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.row_search_result,
                    parent,
                    false
                )
            )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        @Suppress("UNCHECKED_CAST")
        (holder as BaseViewHolder<View, ListItem>).bindViews(
            context,
            items[position],
            listener,
            position
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }
}