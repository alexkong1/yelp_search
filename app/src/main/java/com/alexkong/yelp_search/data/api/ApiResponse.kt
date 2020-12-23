package com.alexkong.yelp_search.data.api

import com.alexkong.yelp_search.data.model.ApiError

data class ApiResponse<T>(
    val data: T?,
    val error: ApiError?
)