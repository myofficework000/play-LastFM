package com.abhishek.lab.lastfmsearch

import android.content.Context
import com.abhishek.lab.lastfmsearch.managers.SearchManager
import com.abhishek.lab.lastfmsearch.managers.SearchManagerImpl
import com.abhishek.lab.lastfmsearch.services.SearchApiService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 *
 * Created by  Abhishek Pathak on 18-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
class SearchManagerTests {

    @Mock
    lateinit var mockSearchApiService: SearchApiService

    @Mock
    lateinit var context: Context

    private lateinit var searchManager: SearchManager

    private val apiKey = "anAPIKey"
    private val apiVersion = "anAPIVersion"

    @Before
    fun setupTest() {
        MockitoAnnotations.initMocks(this)

        Mockito.`when`(context.getString(R.string.api_key)).thenReturn(apiKey)
        Mockito.`when`(context.getString(R.string.search_api_version)).thenReturn(apiVersion)

        searchManager = SearchManagerImpl(mockSearchApiService, context)
    }

    @Test
    fun searchingTrackMakesApiCall() = runBlocking {

        // Arrange
        val searchText = "some search text"

        // Act
        searchManager.searchTrack(searchText)

        // Assert
        Mockito.verify(
            mockSearchApiService,
            Mockito.times(1)
        ).searchTrack(apiVersion, apiKey, searchText)

        // Needed for the compiler as searchManager calls above return a value
        assert(true)
    }

    @Test
    fun searchingArtistMakesApiCall() = runBlocking {

        // Arrange
        val searchText = "some search text"

        // Act
        searchManager.searchArtist(searchText)

        // Assert
        Mockito.verify(
            mockSearchApiService,
            Mockito.times(1)
        ).searchArtist(apiVersion, apiKey, searchText)

        // Needed for the compiler as searchManager calls above return a value
        assert(true)
    }

    @Test
    fun searchingAlbumMakesApiCall() = runBlocking {

        // Arrange
        val searchText = "some search text"

        // Act
        searchManager.searchAlbum(searchText)

        // Assert
        Mockito.verify(
            mockSearchApiService,
            Mockito.times(1)
        ).searchAlbum(apiVersion, apiKey, searchText)

        // Needed for the compiler as searchManager calls above return a value
        assert(true)
    }
}
