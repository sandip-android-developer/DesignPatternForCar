package com.example.designpatternforcar.vehicle.parts

class Seats : Parts {
    override val selfPrice: Int
        get() = 15000

    override val totalCost: Int
        get() = selfPrice
}