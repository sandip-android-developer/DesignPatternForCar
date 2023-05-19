package com.example.designpatternforcar.vehicle.parts

import com.example.designpatternforcar.vehicle.parts.seats.Seats

class Chasis(
    val type: Type,
    val seatFactory: Seats.SeatFactory
) : Parts {

    val numSeats: Int = when (type) {
        Type.HATCHBACK -> 4
        Type.SEDAN -> 5
        Type.SUV -> 8
        Type.PICKUP -> 6
    }

    val seats: List<Seats> = generateSequence { seatFactory.createSeat() }.take(numSeats).toList()

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