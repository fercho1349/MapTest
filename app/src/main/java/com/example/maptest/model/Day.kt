package com.example.maptest.model

class Day {

    private var dt = 0
    private var temp: Temp? = null
    private var pressure = 0.0
    private var humidity = 0.0
    private var weather: List<Weather?>? = null
    private var speed = 0.0
    private var deg = 0
    private var clouds = 0

    fun getDt(): Int {
        return dt
    }

    fun setDt(dt: Int) {
        this.dt = dt
    }

    fun getTemp(): Temp? {
        return temp
    }

    fun setTemp(temp: Temp?) {
        this.temp = temp
    }

    fun getPressure(): Double {
        return pressure
    }

    fun setPressure(pressure: Double) {
        this.pressure = pressure
    }

    fun getHumidity(): Double {
        return humidity
    }

    fun setHumidity(humidity: Double) {
        this.humidity = humidity
    }

    fun getWeather(): List<Weather?>? {
        return weather
    }

    fun setWeather(weather: List<Weather?>?) {
        this.weather = weather
    }

    fun getSpeed(): Double {
        return speed
    }

    fun setSpeed(speed: Double) {
        this.speed = speed
    }

    fun getDeg(): Int {
        return deg
    }

    fun setDeg(deg: Int) {
        this.deg = deg
    }

    fun getClouds(): Int {
        return clouds
    }

    fun setClouds(clouds: Int) {
        this.clouds = clouds
    }

}