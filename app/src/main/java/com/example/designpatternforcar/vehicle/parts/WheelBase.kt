package com.example.designpatternforcar.vehicle.parts

class WheelBase : Parts {
    val chasis: Chasis = Chasis()
    val wheels: List<Wheel> = listOf(
        Wheel(), Wheel(), Wheel(), Wheel()
    )
    override val price: Int
        get() = 125000
}