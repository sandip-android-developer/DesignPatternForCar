package com.example.designpatternforcar.vehicle.parts

import com.example.designpatternforcar.vehicle.parts.seats.Seats

class Chasis private constructor(
    private val type: Type,
    private val seats: List<Seats>
) : Parts {


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

    class Builder {
        lateinit var chasisType: Type
        lateinit var seatFactory: Seats.SeatFactory

        fun setChasisType(chasisType: Type): Builder {
            this.chasisType = chasisType
            return this
        }

        fun setSeatFactory(seatFactory: Seats.SeatFactory): Builder {
            this.seatFactory = seatFactory
            return this
        }

        fun build(): Chasis {
            val numSeats: Int = when (this.chasisType) {
                Type.HATCHBACK -> 4
                Type.SEDAN -> 5
                Type.SUV -> 8
                Type.PICKUP -> 6
            }
            return Chasis(
                this.chasisType,
                this.seatFactory.createSeats(numSeats)
            )
        }
    }
}