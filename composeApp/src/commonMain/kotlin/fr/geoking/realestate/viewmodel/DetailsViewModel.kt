package fr.geoking.realestate.presentation.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import fr.geoking.realestate.data.ListingRepository
import fr.geoking.realestate.model.Listing
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
