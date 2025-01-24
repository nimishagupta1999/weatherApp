package com.nimishagupta.weatherapp2.api

import androidx.lifecycle.LiveData
import com.nimishagupta.weatherapp2.model.WeatherApiResponse

data class Data<T>(
    val weatherData : LiveData<WeatherApiResponse>,
    val networkState: LiveData<NetworkState>
)
