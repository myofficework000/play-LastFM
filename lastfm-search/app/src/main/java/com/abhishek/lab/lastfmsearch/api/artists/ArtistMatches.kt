package com.abhishek.lab.lastfmsearch.api.artists

import com.google.gson.annotations.SerializedName

class ArtistMatches(
    @SerializedName("artistmatches")
    val artistList: ArtistList
)