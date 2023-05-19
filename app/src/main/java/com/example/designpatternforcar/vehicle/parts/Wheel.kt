package com.example.designpatternforcar.vehicle.parts

class Wheel : Parts {
    override val selfPrice: Int
        get() = 12000


    override val totalCost: Int
        get() = selfPrice
}