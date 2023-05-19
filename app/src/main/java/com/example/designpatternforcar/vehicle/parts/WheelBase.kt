package com.example.designpatternforcar.vehicle.parts

class WheelBase(
    val size: Size,
    val chasis: Chasis
) : Parts {
    val wheels: List<Wheel> = listOf(
        Wheel(), Wheel(), Wheel(), Wheel()
    )
    override val selfPrice: Int
        get() = when (size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.BIG -> 175000
        }

    override val totalCost: Int
        get() = selfPrice + chasis.totalCost + wheels.sumOf { it.totalCost }

    enum class Size {
        SMALL, MEDIUM, BIG
    }
}