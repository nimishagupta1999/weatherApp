package com.nimishagupta.weatherapp2.api

sealed class NetworkState {
    object SUCCESS : NetworkState()
    object LOADING : NetworkState()
    data class ERROR(val msg: String): NetworkState()
}

