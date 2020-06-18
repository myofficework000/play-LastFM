package com.abhishek.lab.lastfmsearch.adapters

/**
 *
 * Created by  Abhishek Pathak on 17-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
open class ListItemHeader(val header: String) : ListItem {

    override fun getListItemType(): ListItem.Type {
        return ListItem.Type.HEADER
    }

}