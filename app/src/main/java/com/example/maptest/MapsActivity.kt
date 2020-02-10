package com.example.maptest

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.maptest.model.WeatherAPIResult
import com.example.maptest.retrofit.APIService
import com.example.maptest.retrofit.RestClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private lateinit var mMap: GoogleMap
    private val KEY_CAMERA_POSITION = "camera_position"
    private val DEFAULT_ZOOM = 17f
    private val title = "MapTest"
    private val cdmx = "Ciudad de México"
    private val gdl = "Guadalajara"
    private val mty = "Monterrey"
    private var city = "Ciudad de México"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = title
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val service: APIService? = RestClient.getClient()
        //We need to pass our city ID and our openweathermap APPID
        //We need to pass our city ID and our openweathermap APPID
        val call: Call<WeatherAPIResult?>? =
            service?.getWeather(3996063, "357ab79179547d5af65dc479d472dfc7")
        call?.enqueue(object : Callback<WeatherAPIResult?> {
            override fun onResponse(call: Call<WeatherAPIResult?>,
                response: Response<WeatherAPIResult?>) {
                if (response.isSuccessful) { //Handle the received weather data here
                    val result: WeatherAPIResult? = response.body()
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    //textView.setText(gson.toJson(result))
                    city = gson.toJson(result)
                } else {
                    Log.e(
                        "MainActivity",
                        "Response received but request not successful. Response: " + response.raw()
                    )
                    //textView.setText("Response received but request not successful. Response: " + response.raw())
                    city = "Response received but request not successful. Response: " + response.raw()
                }
            }

            override fun onFailure(call: Call<WeatherAPIResult?>, t: Throwable) {
                Log.e("MainActivity", "Request error!")
            }

        })

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapClickListener(this)
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true
        setPositionMap(cdmx, 19.4284706, -99.1276627)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.country, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_cdmx -> {
            city = cdmx
            setPositionMap(cdmx, 19.4284706, -99.1276627)
            true
        }R.id.action_monterrey -> {
            city = mty
            setPositionMap(mty, 25.6750698, -100.3184662)
            true
        } R.id.action_guadalajara -> {
            city = gdl
            setPositionMap(gdl, 20.6668205, -103.3918228)
            true
        }else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun setPositionMap(city: String, lat: Double, lng: Double){
        val latLng = LatLng(lat, lng)
        mMap.addMarker(MarkerOptions().position(latLng).title(city))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, DEFAULT_ZOOM))
        mMap.uiSettings.isMyLocationButtonEnabled = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(KEY_CAMERA_POSITION, mMap.cameraPosition)
        super.onSaveInstanceState(outState)
    }

    override fun onMapClick(p0: LatLng?) {
        mMap.clear()
        mMap.addMarker(MarkerOptions().position(p0!!).title(city))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(p0, DEFAULT_ZOOM))
        mMap.uiSettings.isMyLocationButtonEnabled = false
    }

}
