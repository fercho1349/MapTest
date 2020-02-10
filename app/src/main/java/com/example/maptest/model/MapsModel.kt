package com.example.maptest.model

import com.example.maptest.contract.ContractInterface
import com.example.maptest.retrofit.APIService
import com.example.maptest.retrofit.RestClient
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapsModel {

    interface OnMapsModelListener {
        fun onFailure(result: String)
        fun onResponse(result: String)
    }

    fun mapsModel(listener: OnMapsModelListener){
        val service: APIService? = RestClient.getClient()
        //We need to pass our city ID and our openweathermap APPID
        //We need to pass our city ID and our openweathermap APPID
        val call: Call<WeatherAPIResult?>? =
            service?.getWeather(3996063, "357ab79179547d5af65dc479d472dfc7")
        call?.enqueue(object : Callback<WeatherAPIResult?> {
            override fun onResponse(call: Call<WeatherAPIResult?>,
                                    response: Response<WeatherAPIResult?>) {
                if (response.isSuccessful) {
                    val result: WeatherAPIResult? = response.body()
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    listener.onResponse(gson.toJson(result))
                } else {
                    listener.onFailure("Response received but request not successful. Response: " + response.raw())
                }
            }

            override fun onFailure(call: Call<WeatherAPIResult?>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }
        })
    }

}