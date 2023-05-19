package com.example.designpatternforcar.vehicle.parts

class Chasis(val type: Type) : Parts {

    val seats: List<Seats> = listOf(
        Seats(), Seats(), Seats(), Seats()
    )
    override val selfPrice: Int
        get() = when (type) {
            Type.HATCHBACK -> 150000
            Type.SEDAN -> 200000
            Type.SUV -> 250000
            Type.PICKUP -> 350000
        }
    override val totalCost: Int
        get() = selfPrice + seats.sumOf { it.totalCost }

    enum class Type {
        HATCHBACK, SEDAN, SUV, PICKUP
    }
}