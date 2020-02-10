package com.example.maptest.model

class Coord {

    private var lon = 0.0
    private var lat = 0.0

    fun getLon(): Double {
        return lon
    }

    fun setLon(lon: Double) {
        this.lon = lon
    }

    fun getLat(): Double {
        return lat
    }

    fun setLat(lat: Double) {
        this.lat = lat
    }

}