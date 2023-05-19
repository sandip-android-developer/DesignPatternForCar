package com.example.designpatternforcar.vehicle

import com.example.designpatternforcar.vehicle.parts.Engine
import com.example.designpatternforcar.vehicle.parts.WheelBase

class Vehicle(
    val wheelBase: WheelBase,
    val engine: Engine
) {
    val price: Int = wheelBase.totalCost + engine.totalCost
}