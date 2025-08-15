package com.firebnb.data

import com.firebnb.model.Listing

interface ListingRepository {
    suspend fun getListings(): List<Listing>
    suspend fun getListing(id: String): Listing?
    suspend fun toggleFavorite(listingId: String)
    suspend fun getFavoriteListings(): List<Listing>
}
