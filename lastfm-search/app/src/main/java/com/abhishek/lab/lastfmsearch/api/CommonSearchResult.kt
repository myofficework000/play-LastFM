package com.abhishek.lab.lastfmsearch.api

import android.os.Parcelable
import com.abhishek.lab.lastfmsearch.model.SearchResultType
import kotlinx.android.parcel.Parcelize

@Parcelize
class CommonSearchResult(
    val resultType: SearchResultType,
    val id: String,
    val title: String,
    val subTitle: String,
    val url: String?,
    val imageUrlMedium: String?,
    val imageUrlLarge: String?
) : Parcelable