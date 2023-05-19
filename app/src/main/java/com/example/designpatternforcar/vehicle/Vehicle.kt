package com.example.designpatternforcar.vehicle

import com.example.designpatternforcar.vehicle.parts.Engine
import com.example.designpatternforcar.vehicle.parts.WheelBase

class Vehicle {

    val wheelBase: WheelBase = WheelBase()
    val engine: Engine = Engine()

    val price: Int
        get() {
            var costs = 0
            costs += wheelBase.price
            costs += wheelBase.wheels.sumOf { it.price }
            costs += wheelBase.chasis.price
            costs += wheelBase.chasis.seats.sumOf { it.price }
            costs += engine.price
            costs += engine.transmission.price
            return costs
        }
}