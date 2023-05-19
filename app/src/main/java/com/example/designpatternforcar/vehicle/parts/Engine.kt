package com.example.designpatternforcar.vehicle.parts

class Engine : Parts {
    val transmission: Transmission = Transmission()

    override val price: Int
        get() = 150000
}