package com.example.maptest.model

class WeatherAPIResult {

    private var city: City? = null
    private var cod = 0
    private var message = 0.0
    private var cnt = 0
    private var list: List<Day> = ArrayList<Day>()

    fun getCity(): City? {
        return city
    }

    fun setCity(city: City?) {
        this.city = city
    }

    fun getCod(): Int {
        return cod
    }

    fun setCod(cod: Int) {
        this.cod = cod
    }

    fun getMessage(): Double {
        return message
    }

    fun setMessage(message: Double) {
        this.message = message
    }

    fun getCnt(): Int {
        return cnt
    }

    fun setCnt(cnt: Int) {
        this.cnt = cnt
    }

    fun getList(): List<Day>? {
        return list
    }

    fun setList(list: List<Day>) {
        this.list = list
    }

}