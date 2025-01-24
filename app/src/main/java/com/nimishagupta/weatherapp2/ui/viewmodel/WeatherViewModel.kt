package com.nimishagupta.weatherapp2.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nimishagupta.weatherapp2.api.Data
import com.nimishagupta.weatherapp2.api.NetworkState
import com.nimishagupta.weatherapp2.model.WeatherApiResponse
import com.nimishagupta.weatherapp2.model.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {
    //val repository = WeatherRepository()
    var networkState = MutableLiveData<NetworkState>()
    var mutableLiveData = MutableLiveData<WeatherApiResponse>()

    fun fetchWeatherForCity(city: String?): Data<WeatherApiResponse> {
        viewModelScope.launch {
            networkState.postValue(NetworkState.LOADING)
            val response = repository.fetchWeatherData(city)
            if (response != null) {
                networkState.postValue(NetworkState.SUCCESS)
                mutableLiveData.postValue(response)
            } else {
                mutableLiveData.postValue(null)
                networkState.postValue(NetworkState.ERROR("Invalid request"))
            }
        }
        return Data(mutableLiveData,networkState)
    }
}