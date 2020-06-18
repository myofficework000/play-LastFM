package com.abhishek.lab.lastfmsearch.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created by  Abhishek Pathak on 16-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
class Artist(
    val mbid: String,
    val name: String,
    val listeners: Int,
    val url: String,

    @SerializedName("image")
    val images: List<Image>?
)