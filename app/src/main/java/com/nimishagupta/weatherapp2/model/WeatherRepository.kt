package com.nimishagupta.weatherapp2.model

import com.nimishagupta.weatherapp2.api.WeatherService
import com.nimishagupta.weatherapp2.utils.API_KEY
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherService: WeatherService) {
    //private val weatherService: WeatherService = RetrofitInstance.getWeatherService()

    suspend fun fetchWeatherData(city: String?): WeatherApiResponse? {
        val response = weatherService.getWeatherForCity(API_KEY, city)
        if(response.isSuccessful) {
            return response.body()
        }
        return null
    }

}