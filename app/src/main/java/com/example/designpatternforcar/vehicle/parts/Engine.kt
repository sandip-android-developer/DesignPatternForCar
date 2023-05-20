package com.example.designpatternforcar.vehicle.parts

class Engine(
    private val type: Type,
    private val transmission: Transmission
) : Parts {

    override val selfPrice: Int
        get() = when (type) {
            Type.PETROL -> 100000
            Type.DIESEL -> 200000
            Type.HYBRID -> 500000
            Type.ELECTRIC -> 400000
        }

    override val totalCost: Int
        get() = selfPrice + transmission.totalCost

    enum class Type { PETROL, DIESEL, HYBRID, ELECTRIC }
}