package com.example.maptest.retrofit

import com.example.maptest.model.WeatherAPIResult
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface APIService {

    @GET("/data/2.5/weather?")
    fun getWeather(@Query("id") cityID: Int, @Query("APPID") appID: String?): Call<WeatherAPIResult?>?

}