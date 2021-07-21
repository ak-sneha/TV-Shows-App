package com.example.core.domain

import com.google.gson.annotations.SerializedName

//data class TVSeries(
//    @SerializedName("score")
//    val score: Double?,
//    @SerializedName("show")
//    val show: Show?
//)

data class TVSeries(

    @SerializedName("id")
    val id: Int?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rating")
    val rating: Rating?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("image")
    val image: Image?
)

data class Rating(
    @SerializedName("average")
    val average: Double?
)

data class Image(
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("original")
    val original: String?
)
