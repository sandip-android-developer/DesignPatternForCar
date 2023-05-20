package com.example.designpatternforcar.vehicle.parts

class Transmission(private val type: Type) : Parts {
    override val selfPrice: Int
        get() = when (type) {
            Type.RWD -> 90000
            Type.FWD -> 75000
            Type.AWD -> 110000
        }

    override val totalCost: Int
        get() = selfPrice

    //RWD-Real wheel drive
    //FWD-Forward wheel drive
    //AWD -All wheel drive
    enum class Type {
        RWD, FWD, AWD
    }
}