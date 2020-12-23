package com.alexkong.yelp_search.data.model

import androidx.annotation.WorkerThread
import com.alexkong.yelp_search.data.Resource
import com.alexkong.yelp_search.data.api.ApiResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

abstract class NetworkBoundResource<DataLayerType>
@WorkerThread constructor(){
    private var result: Observable<Resource<DataLayerType>>

    init {
        result = createCall()
            .subscribeOn(Schedulers.io())
            .map {
                    apiResponse ->
                return@map determineResource(apiResponse)
            }.onErrorReturn { throwable ->
                return@onErrorReturn Resource.error(throwable)
            }
    }

    // Called to save the result of the API response into the database
    @WorkerThread
    protected abstract fun saveCallResult(item: DataLayerType)

    // Called with the data in the database to decide whether to fetch
    // potentially updated data from the network.
    @WorkerThread
    protected abstract fun shouldFetch(data: DataLayerType?): Boolean

    // Called to get the cached data from the database.
    //@WorkerThread
    //protected abstract fun loadFromDb(): Observable<DataLayerType>

    // Called to create the API call.
    @WorkerThread
    protected abstract fun createCall(): Observable<ApiResponse<DataLayerType>>

    // Called when the fetch fails. The child class may want to reset components
    // like rate limiter.
    protected open fun onFetchFailed() {}

    // Returns a LiveData object that represents the resource that's implemented
    // in the base class.
    //fun asLiveData(): LiveData<ResultType> = TODO()

    fun result() = result

    /**
     * Determine if the ApiResponse is a Success or Error Resource
     *
     * @return a valid Resource object
     */
    private fun determineResource(resource: ApiResponse<DataLayerType>): Resource<DataLayerType> {

        if (resource.data != null) {
            return Resource.success(resource.data)
        }

        if (resource.error != null) {
            return Resource.error(Throwable(resource.error.code))
        }

        return Resource.error(IllegalArgumentException("The ApiResponse is malformed"))
    }
}