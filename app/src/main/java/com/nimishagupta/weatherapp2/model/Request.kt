package com.nimishagupta.weatherapp2.model
import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("language")
    val language: String,
    @SerializedName("query")
    val query: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("unit")
    val unit: String
)