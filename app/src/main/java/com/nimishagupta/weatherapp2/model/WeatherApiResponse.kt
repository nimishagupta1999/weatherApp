package com.nimishagupta.weatherapp2.model
import com.google.gson.annotations.SerializedName

data class WeatherApiResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location,
    @SerializedName("request")
    val request: Request
)