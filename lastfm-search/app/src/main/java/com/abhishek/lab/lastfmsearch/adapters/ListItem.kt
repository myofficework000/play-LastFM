package com.abhishek.lab.lastfmsearch.adapters

/**
 *
 * Created by  Abhishek Pathak on 17-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
interface ListItem {

    enum class Type {
        RESULT,
        HEADER,
    }

    fun getListItemType(): Type
}