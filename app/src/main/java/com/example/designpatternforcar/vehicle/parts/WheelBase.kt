package com.example.designpatternforcar.vehicle.parts

import com.example.designpatternforcar.vehicle.parts.wheel.Wheel

class WheelBase(
    val size: Size,
    val chasis: Chasis,
    val wheelFactory: Wheel.WheelFactory,
    val spareWhee: Boolean = false
) : Parts {

    val numWheels: Int = when (size) {
        Size.SMALL -> 4
        Size.MEDIUM -> 6
        Size.BIG -> 8
    }
    val wheels: List<Wheel> =
        generateSequence { wheelFactory.createWheel() }.take((numWheels + (if (spareWhee) 1 else 0)))
            .toList()
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