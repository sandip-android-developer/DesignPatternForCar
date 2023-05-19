package com.example.designpatternforcar

import com.example.designpatternforcar.vehicle.Vehicle

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val vehicle: Vehicle = Vehicle()
            println("My car's price is = ${vehicle.price}")

        }
    }
}