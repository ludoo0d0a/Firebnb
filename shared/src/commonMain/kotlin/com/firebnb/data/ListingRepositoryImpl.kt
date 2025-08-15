package com.firebnb.data

import com.firebnb.model.Listing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListingRepositoryImpl : ListingRepository {
    override suspend fun getListings(): List<Listing> {
        return withContext(Dispatchers.Default) {
            MockData.listings
        }
    }

    override suspend fun getListing(id: String): Listing? {
        return withContext(Dispatchers.Default) {
            MockData.listings.find { it.id == id }
        }
    }

    override suspend fun toggleFavorite(listingId: String) {
        withContext(Dispatchers.Default) {
            val listing = MockData.listings.find { it.id == listingId }
            listing?.isFavorite = !(listing?.isFavorite ?: false)
        }
    }

    override suspend fun getFavoriteListings(): List<Listing> {
        return withContext(Dispatchers.Default) {
            MockData.listings.filter { it.isFavorite }
        }
    }
}
