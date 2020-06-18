package com.abhishek.lab.lastfmsearch.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created by  Abhishek Pathak on 16-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
class Track(
    val name: String,
    val artist: String,
    val url: String,
    val listeners: Int,
    val mbid: String,

    @SerializedName("image")
    val images: List<Image>?
)