package com.alexkong.yelp_search.data

import com.alexkong.yelp_search.data.model.SearchResult
import com.alexkong.yelp_search.inject.AppScope
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@AppScope
class DataManager
@Inject constructor(
    private val searchRepository: SearchRepository
){

    fun searchByTerm(term: String,
                     latitude: Float,
                     longitude: Float,
                     observer: Observer<Resource<SearchResult>>
    ): Disposable {
        return searchRepository.searchByTerm(
            term,
            latitude,
            longitude
        ).subscribeWith(observer) as Disposable
    }
}