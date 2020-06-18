package com.abhishek.lab.lastfmsearch.adapters

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.abhishek.lab.lastfmsearch.adapters.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.row_search_result.view.*

/**
 *
 * Created by  Abhishek Pathak on 17-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
class SearchResultViewHolder(view: View) : RecyclerView.ViewHolder(view),
    BaseViewHolder<View, ListItem> {

    override fun bindViews(
        context: Context,
        data: ListItem,
        listener: ListClickListener<View, ListItem>,
        position: Int
    ) {

        val searchResult = (data as ListItemResult).searchResult

        title.text = searchResult.title
        subTitle.text = searchResult.subTitle

        Glide.with(image)
            .load(searchResult.imageUrlMedium)
            .into(image)

        cardView.setOnClickListener {
            listener.onRowTap(it, data)
        }
    }

    private val cardView: View = view.search_result_card_view
    private val title: TextView = view.title
    private val subTitle: TextView = view.subtitle
    private val image: ImageView = view.search_result_image
}