package com.abhishek.lab.lastfmsearch.managers

import com.abhishek.lab.lastfmsearch.api.albums.AlbumSearchResult
import com.abhishek.lab.lastfmsearch.api.artists.ArtistSearchResult
import com.abhishek.lab.lastfmsearch.api.tracks.TrackSearchResult

/**
 *
 * Created by  Abhishek Pathak on 16-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
interface SearchManager {
    suspend fun searchAlbum(searchText: String): AlbumSearchResult?
    suspend fun searchTrack(searchText: String): TrackSearchResult?
    suspend fun searchArtist(searchText: String): ArtistSearchResult?
}