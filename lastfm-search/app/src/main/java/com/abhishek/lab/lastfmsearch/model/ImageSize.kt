package com.abhishek.lab.lastfmsearch.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created by  Abhishek Pathak on 16-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
enum class ImageSize {

    @SerializedName("small")
    Small,

    @SerializedName("medium")
    Medium,

    @SerializedName("large")
    Large,

    @SerializedName("extralarge")
    ExtraLarge,

    @SerializedName("mega")
    Mega
}

