package com.abhishek.lab.lastfmsearch.adapters

import com.abhishek.lab.lastfmsearch.api.CommonSearchResult

/**
 *
 * Created by  Abhishek Pathak on 17-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
open class ListItemResult(
    val searchResult: CommonSearchResult
) : ListItem {

    override fun getListItemType(): ListItem.Type {
        return ListItem.Type.RESULT
    }

}