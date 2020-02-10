package com.example.maptest.model

class City {

    private var id = 0
    private var name: String? = null
    private var coord: Coord? = null
    private var country: String? = null
    private var population = 0

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getCoord(): Coord? {
        return coord
    }

    fun setCoord(coord: Coord?) {
        this.coord = coord
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getPopulation(): Int {
        return population
    }

    fun setPopulation(population: Int) {
        this.population = population
    }

}