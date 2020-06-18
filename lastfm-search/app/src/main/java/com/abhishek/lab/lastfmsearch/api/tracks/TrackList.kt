package com.abhishek.lab.lastfmsearch.api.tracks

import com.abhishek.lab.lastfmsearch.model.Track
import com.google.gson.annotations.SerializedName

class TrackList(
    @SerializedName("track")
    val tracks: List<Track>
)