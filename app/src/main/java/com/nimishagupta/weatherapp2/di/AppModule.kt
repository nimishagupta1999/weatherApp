package com.nimishagupta.weatherapp2.di

import com.nimishagupta.weatherapp2.api.RetrofitInstance
import com.nimishagupta.weatherapp2.api.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesWeatherService(): WeatherService = RetrofitInstance.getWeatherService()

}