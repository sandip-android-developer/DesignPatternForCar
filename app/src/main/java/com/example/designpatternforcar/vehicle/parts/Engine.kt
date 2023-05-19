package com.example.designpatternforcar.vehicle.parts

class Engine(
    val type: Type,
    val transmission: Transmission
) : Parts {

    override val selfPrice: Int
        get() = when (type) {
            Type.PETRO -> 100000
            Type.DIESEL -> 200000
            Type.HYBRID -> 500000
            Type.ELECTRIC -> 400000
        }

    override val totalCost: Int
        get() = selfPrice + transmission.totalCost

    enum class Type { PETRO, DIESEL, HYBRID, ELECTRIC }
}