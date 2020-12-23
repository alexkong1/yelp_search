package com.alexkong.yelp_search.data

import androidx.lifecycle.LiveData
import com.alexkong.yelp_search.BuildConfig
import com.alexkong.yelp_search.data.api.ApiResponse
import com.alexkong.yelp_search.data.model.NetworkBoundResource
import com.alexkong.yelp_search.data.model.SearchResult
import com.alexkong.yelp_search.inject.AppScope
import io.reactivex.Observable
import javax.inject.Inject

@AppScope
class SearchRepository
@Inject constructor(
    private val service: YelpApi
) {

    fun searchByTerm(term: String, latitude: Float, longitude: Float):Observable<Resource<SearchResult>> {
        return object : NetworkBoundResource<SearchResult> () {
            override fun saveCallResult(item: SearchResult) {
                //TODO("Not yet implemented")
            }

            override fun shouldFetch(data: SearchResult?): Boolean {
                return true
            }
/*
            override fun loadFromDb(): Observable<SearchResult> {
                //TODO("Not yet implemented")
            }
*/
            override fun createCall(): Observable<ApiResponse<SearchResult>> {
                return service.searchBusinesses(
                    BuildConfig.API_KEY,
                    mapOf("term" to term,
                        "latitude" to latitude.toString(),
                        "longitude" to longitude.toString())
                )
            }

            override fun onFetchFailed() {
                super.onFetchFailed()
            }
        }.result()
    }
}