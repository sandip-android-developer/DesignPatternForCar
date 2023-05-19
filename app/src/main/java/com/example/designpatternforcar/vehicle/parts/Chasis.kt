package com.example.designpatternforcar.vehicle.parts

class Chasis :Parts{

    val seats: List<Seats> = listOf(
        Seats(), Seats(), Seats(), Seats()
    )
    override val price: Int
        get() = 200000
}