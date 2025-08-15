package com.firebnb.presentation.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.firebnb.data.ListingRepository
import com.firebnb.model.Listing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val repository: ListingRepository,
    private val listingId: String
) : ScreenModel {

    private val _listing = MutableStateFlow<Listing?>(null)
    val listing = _listing.asStateFlow()

    init {
        loadListing()
    }

    private fun loadListing() {
        coroutineScope.launch {
            _listing.value = repository.getListing(listingId)
        }
    }
}
