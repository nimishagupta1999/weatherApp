package com.nimishagupta.weatherapp2.api

import com.nimishagupta.weatherapp2.model.WeatherApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current")
    suspend fun getWeatherForCity(@Query("access_key") access_key: String, @Query("query") city: String? = "Bangalore"): Response<WeatherApiResponse>


    companion object {
        const val CUSTOM_ENDPOINT = "https://api.weatherstack.com/"
    }
}