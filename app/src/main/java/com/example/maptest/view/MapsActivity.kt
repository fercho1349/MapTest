package com.example.maptest.view

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.maptest.R
import com.example.maptest.contract.ContractInterface
import com.example.maptest.model.MapsModel
import com.example.maptest.presenter.MapsPresenter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapClickListener, ContractInterface.View {

    private lateinit var mMap: GoogleMap
    private val KEY_CAMERA_POSITION = "camera_position"
    private val DEFAULT_ZOOM = 17f
    private val title = "MapTest"
    private var weather = "Ciudad de México"
    private var presenter: MapsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        presenter = MapsPresenter(this, MapsModel())
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapClickListener(this)
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true
        setPositionMap(weather, 19.4284706, -99.1276627)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.country, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_cdmx -> {
            setPositionMap(weather, 19.4284706, -99.1276627)
            true
        }
        R.id.action_monterrey -> {
            setPositionMap(weather, 25.6750698, -100.3184662)
            true
        } R.id.action_guadalajara -> {
            setPositionMap(weather, 20.6668205, -103.3918228)
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
        presenter = MapsPresenter(this, MapsModel())
        mMap.clear()
        mMap.addMarker(MarkerOptions().position(p0!!).title(weather))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(p0, DEFAULT_ZOOM))
        mMap.uiSettings.isMyLocationButtonEnabled = false
    }

    override fun initView() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = title
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun updateViewData(result: String) {
        weather = result
    }

    override fun updateErrorViewData(result: String) {
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }

}
