package com.alexkong.yelp_search.data.model

data class Business(
        val rating: Float? = 0.0f, //4.5,
        val price: String?,//"$$",
        val phone: String?,//"+14154212337",
        val id: String?,// "molinari-delicatessen-san-francisco",
        val categories: List<Category> = listOf(),
        val review_count: Int?,// 910,
        val name: String?,//"Molinari Delicatessen",
        val url: String?,//"https://www.yelp.com/biz/molinari-delicatessen-san-francisco",
        val coordinates: Coordinates,
        val image_url: String?,//"http://s3-media4.fl.yelpcdn.com/bphoto/6He-NlZrAv2mDV-yg6jW3g/o.jpg",
        val location: Location?
)