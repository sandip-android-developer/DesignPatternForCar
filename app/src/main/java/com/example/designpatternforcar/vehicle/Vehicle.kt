package com.example.designpatternforcar.vehicle

import com.example.designpatternforcar.vehicle.parts.Chasis
import com.example.designpatternforcar.vehicle.parts.Engine
import com.example.designpatternforcar.vehicle.parts.WheelBase

class Vehicle private constructor(
    private val wheelBase: WheelBase,
    private val chasis: Chasis,
    private val engine: Engine
) {
    val price: Int = wheelBase.totalCost + engine.totalCost + this.chasis.totalCost

    class Builder() {
        lateinit var wheelBase: WheelBase
        lateinit var engine: Engine
        lateinit var chasis: Chasis

        fun setWheelBase(wheelBase: WheelBase): Builder {
            this.wheelBase = wheelBase
            return this
        }

        fun setEngine(engine: Engine): Builder {
            this.engine = engine
            return this
        }

        fun setChasis(chasis: Chasis): Builder {
            this.chasis = chasis
            return this
        }

        fun getPrice(): Int {
            return this.wheelBase.totalCost + this.engine.totalCost + this.chasis.totalCost
        }

        fun build(): Vehicle {
            return Vehicle(
                this.wheelBase,
                this.chasis,
                this.engine
            )
        }
    }
}