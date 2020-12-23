package com.alexkong.yelp_search.data.model

data class ApiError(
    val code: String?,
    val description: String?,
    val field: String?,
    val instance: String?
){}