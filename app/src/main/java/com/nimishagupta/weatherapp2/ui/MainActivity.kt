package com.nimishagupta.weatherapp2.ui

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.nimishagupta.weatherapp2.api.NetworkState
import com.nimishagupta.weatherapp2.databinding.ActivityMainBinding
import com.nimishagupta.weatherapp2.ui.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import com.nimishagupta.weatherapp2.api.Data
import com.nimishagupta.weatherapp2.model.WeatherApiResponse


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    //lateinit var viewModel: WeatherViewModel
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        //viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        if (viewModel.mutableLiveData == null) {
            viewModel.fetchWeatherForCity("Bangalore")
        }



        viewModel.mutableLiveData.observe(this) {

            activityMainBinding.latVal.text = it.location.lat
            activityMainBinding.longVal.text = it.location.lon
            activityMainBinding.tempVal.text = it.current.temperature.toString()


            Glide.with(this)
                .load(it.current.weatherIcons[0])
                .into(activityMainBinding.appIcon)

            activityMainBinding.title.text = it.location.name
        }


        //Loader handling
        viewModel.networkState.observe(this) {
            when(it) {
                is NetworkState.LOADING -> activityMainBinding.loader.visibility = View.VISIBLE
                else -> activityMainBinding.loader.visibility = View.GONE
            }
        }


        //Button click handling

        activityMainBinding.btn.setOnClickListener {
            val requestCity = activityMainBinding.editCity.text.toString()
            if (requestCity.isNotEmpty()) {
                viewModel.fetchWeatherForCity(requestCity)

            }
        }


    }
}