package com.example.designpatternforcar.vehicle.parts

import com.example.designpatternforcar.vehicle.parts.wheel.Wheel

class WheelBase private constructor(
    private val size: Size,
    private val wheels: List<Wheel>
) : Parts {
    override val selfPrice: Int
        get() = when (size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.LARGE -> 175000
        }

    override val totalCost: Int
        get() = selfPrice + wheels.sumOf { it.totalCost }

    enum class Size {
        SMALL, MEDIUM, LARGE
    }

    class Builder {
        lateinit var wheelBaseSize: Size
        lateinit var wheelFactory: Wheel.WheelFactory
        var spareWheel: Boolean = false

        fun setWheelBaseSize(wheelBaseSize: Size): Builder {
            this.wheelBaseSize = wheelBaseSize
            return this
        }



        fun setWheelFactory(wheelFactory: Wheel.WheelFactory): Builder {
            this.wheelFactory = wheelFactory
            return this
        }

        fun setSpareWheel(spareWheel: Boolean): Builder {
            this.spareWheel = spareWheel
            return this
        }

        fun build(): WheelBase {
            val numWheels: Int = when (this.wheelBaseSize) {
                Size.SMALL -> 4
                Size.MEDIUM -> 6
                Size.LARGE -> 8
            }

            return WheelBase(
                this.wheelBaseSize,
                this.wheelFactory.createWheels(numWheels + if (spareWheel) 1 else 0)
            )
        }
    }
}