package com.example.designpatternforcar.vehicle.parts

import com.example.designpatternforcar.vehicle.parts.wheel.Wheel

class WheelBase(
    private val size: Size,
    private val chasis: Chasis,
    val wheelFactory: Wheel.WheelFactory,
    val spareWhee: Boolean = false
) : Parts {

    private val numWheels: Int = when (size) {
        Size.SMALL -> 4
        Size.MEDIUM -> 6
        Size.LARGE -> 8
    }
    private val wheels: List<Wheel> =
        generateSequence { wheelFactory.createWheel() }.take((numWheels + (if (spareWhee) 1 else 0)))
            .toList()
    override val selfPrice: Int
        get() = when (size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.LARGE -> 175000
        }

    override val totalCost: Int
        get() = selfPrice + chasis.totalCost + wheels.sumOf { it.totalCost }

    enum class Size {
        SMALL, MEDIUM, LARGE
    }
}