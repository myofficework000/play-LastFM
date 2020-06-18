package com.abhishek.lab.lastfmsearch.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.lab.lastfmsearch.api.CommonSearchResult
import com.abhishek.lab.lastfmsearch.extensions.toCommonSearchResult
import com.abhishek.lab.lastfmsearch.managers.SearchManager
import com.abhishek.lab.lastfmsearch.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(val searchManager: SearchManager) : ViewModel() {

    val searchResultsLive: SingleLiveEvent<List<CommonSearchResult>> by lazy {
        SingleLiveEvent<List<CommonSearchResult>>()
    }

    val searchResultsCombined = mutableListOf<CommonSearchResult>()

    fun search(searchText: String) {

        if (searchText.isBlank()) return

        viewModelScope.launch(Dispatchers.IO) {

            searchResultsCombined.clear()

            val trackSearchResult = searchManager.searchTrack(searchText)
            val artistSearchResult = searchManager.searchArtist(searchText)
            val albumSearchResult = searchManager.searchAlbum(searchText)

            trackSearchResult?.toCommonSearchResult()?.let { searchResultsCombined.addAll(it) }
            artistSearchResult?.toCommonSearchResult()?.let { searchResultsCombined.addAll(it) }
            albumSearchResult?.toCommonSearchResult()?.let { searchResultsCombined.addAll(it) }

            searchResultsLive.postValue(searchResultsCombined)
        }
    }
}
