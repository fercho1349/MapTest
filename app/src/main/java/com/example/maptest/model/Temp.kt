package com.example.maptest.model

class Temp {

    private var day = 0.0
    private var min = 0.0
    private var max = 0.0
    private var night = 0.0
    private var eve = 0.0
    private var morn = 0.0

    fun getDay(): Double {
        return day
    }

    fun setDay(day: Double) {
        this.day = day
    }

    fun getMin(): Double {
        return min
    }

    fun setMin(min: Double) {
        this.min = min
    }

    fun getMax(): Double {
        return max
    }

    fun setMax(max: Double) {
        this.max = max
    }

    fun getNight(): Double {
        return night
    }

    fun setNight(night: Double) {
        this.night = night
    }

    fun getEve(): Double {
        return eve
    }

    fun setEve(eve: Double) {
        this.eve = eve
    }

    fun getMorn(): Double {
        return morn
    }

    fun setMorn(morn: Double) {
        this.morn = morn
    }

}