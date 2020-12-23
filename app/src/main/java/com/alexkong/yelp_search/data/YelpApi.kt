package com.alexkong.yelp_search.data

import com.alexkong.yelp_search.data.api.ApiResponse
import com.alexkong.yelp_search.data.model.SearchResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface YelpApi {

    @GET("/businesses/search")
    fun searchBusinesses(
        @Header("Authorization") authorization: String?,
        @QueryMap(encoded = false) params: Map<String, String>
    ): Observable<ApiResponse<SearchResult>>

}