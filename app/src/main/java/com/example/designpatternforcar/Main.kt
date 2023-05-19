package com.example.designpatternforcar

import com.example.designpatternforcar.vehicle.Vehicle
import com.example.designpatternforcar.vehicle.parts.Chasis
import com.example.designpatternforcar.vehicle.parts.Engine
import com.example.designpatternforcar.vehicle.parts.Transmission
import com.example.designpatternforcar.vehicle.parts.WheelBase

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val hondaCity: Vehicle = Vehicle(
                wheelBase = WheelBase(
                    WheelBase.Size.MEDIUM,
                    Chasis(Chasis.Type.SEDAN)
                ),
                engine = Engine(
                    Engine.Type.DIESEL,
                    Transmission(Transmission.Type.FWD)
                )
            )

            val ecoSport = Vehicle(
                wheelBase = WheelBase(
                    WheelBase.Size.SMALL,
                    Chasis(Chasis.Type.SUV)
                ),
                engine = Engine(
                    Engine.Type.DIESEL,
                    Transmission(Transmission.Type.FWD)
                )
            )
            println("Honda city price is = ${hondaCity.price}")
            println("EcoSport price is = ${ecoSport.price}")

        }
    }
}