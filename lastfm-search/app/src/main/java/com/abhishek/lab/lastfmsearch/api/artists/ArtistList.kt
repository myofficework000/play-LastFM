package com.abhishek.lab.lastfmsearch.api.artists

import com.abhishek.lab.lastfmsearch.model.Artist
import com.google.gson.annotations.SerializedName

class ArtistList(
    @SerializedName("artist")
    val artists: List<Artist>
)