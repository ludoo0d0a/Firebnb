package com.firebnb.presentation.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.firebnb.data.ListingRepository
import com.firebnb.model.Listing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: ListingRepository) : ScreenModel {

    private val _listings = MutableStateFlow<List<Listing>>(emptyList())
    val listings = _listings.asStateFlow()

    init {
        loadListings()
    }

    fun loadListings() {
        coroutineScope.launch {
            _listings.value = repository.getListings()
        }
    }

    fun toggleFavorite(listingId: String) {
        coroutineScope.launch {
            repository.toggleFavorite(listingId)
            loadListings()
        }
    }
}
