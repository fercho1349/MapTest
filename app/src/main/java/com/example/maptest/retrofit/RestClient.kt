package com.example.maptest.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {

    //Set up the REST client
    companion object{

        private val baseUrl = "http://api.openweathermap.org"
        private var apiService: APIService? = null

        fun getClient(): APIService? {
            if (apiService == null) {
               /* val okClient = OkHttpClient().newBuilder()
                okClient.interceptors().add(Interceptor { chain -> chain.proceed(chain.request()) })
                val client = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()*/

                val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService =
                    retrofit.create<APIService>(APIService::class.java)
            }
            return apiService
        }
    }

}