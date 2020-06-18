package com.abhishek.lab.lastfmsearch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abhishek.lab.lastfmsearch.managers.SearchManager
import com.abhishek.lab.lastfmsearch.viewmodels.SearchViewModel
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 *
 * Created by  Abhishek Pathak on 18-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
@ExperimentalCoroutinesApi
class SearchViewModelTests {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var mockSearchManager: SearchManager

    private lateinit var searchViewModel: SearchViewModel

    @Before
    fun setupTest() {
        MockitoAnnotations.initMocks(this)
        searchViewModel = SearchViewModel(mockSearchManager)
    }

    @Test
    fun blankSearchTextIsNotSubmitted() = runBlocking {

        // Arrange
        val searchTextBlank = " "

        // Act
        searchViewModel.search(searchTextBlank)

        // Assert
        assertTrue(
            Mockito.verify(
                mockSearchManager,
                Mockito.times(0)
            ).searchAlbum(searchTextBlank) == null
        )

        assertTrue(
            Mockito.verify(
                mockSearchManager,
                Mockito.times(0)
            ).searchTrack(searchTextBlank) == null
        )

        assertTrue(
            Mockito.verify(
                mockSearchManager,
                Mockito.times(0)
            ).searchArtist(searchTextBlank) == null
        )
    }

    @Test
    fun emptySearchTextIsNotSubmitted() = runBlocking {

        // Arrange
        val searchTextEmpty = ""

        // Act
        searchViewModel.search(searchTextEmpty)

        // Assert
        assertTrue(
            Mockito.verify(
                mockSearchManager,
                Mockito.times(0)
            ).searchAlbum(searchTextEmpty) == null
        )

        assertTrue(
            Mockito.verify(
                mockSearchManager,
                Mockito.times(0)
            ).searchTrack(searchTextEmpty) == null
        )
        assertTrue(
            Mockito.verify(
                mockSearchManager,
                Mockito.times(0)
            ).searchArtist(searchTextEmpty) == null
        )
    }

    @Test
    fun serviceManagerIsCalledFromViewModel() = runBlocking {

        // Arrange
        val searchText = "a non-null search text"

        // Act
        searchViewModel.search(searchText)

        coroutineScope {
            // Assert
            Mockito.verify(mockSearchManager, Mockito.times(1)).searchTrack(searchText)
            Mockito.verify(mockSearchManager, Mockito.times(1)).searchAlbum(searchText)
            Mockito.verify(mockSearchManager, Mockito.times(1)).searchArtist(searchText)
        }

        // Needed for the compiler as searchManager calls above return a value
        assertTrue(true)
    }
}
