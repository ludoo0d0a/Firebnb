package fr.geoking.realestate.data

import fr.geoking.realestate.model.Listing

interface ListingRepository {
    suspend fun getListings(): List<Listing>
    suspend fun getListing(id: String): Listing?
    suspend fun toggleFavorite(listingId: String)
    suspend fun getFavoriteListings(): List<Listing>
}
