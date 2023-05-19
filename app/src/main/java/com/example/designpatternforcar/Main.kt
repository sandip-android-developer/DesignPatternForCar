package com.example.designpatternforcar

import com.example.designpatternforcar.vehicle.Vehicle
import com.example.designpatternforcar.vehicle.parts.Chasis
import com.example.designpatternforcar.vehicle.parts.Engine
import com.example.designpatternforcar.vehicle.parts.Transmission
import com.example.designpatternforcar.vehicle.parts.WheelBase
import com.example.designpatternforcar.vehicle.parts.seats.Seats
import com.example.designpatternforcar.vehicle.parts.wheel.Wheel

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val hondaCity: Vehicle = Vehicle(
                wheelBase = WheelBase(
                    WheelBase.Size.MEDIUM,
                    Chasis(
                        Chasis.Type.SEDAN,
                        Seats.SeatFactory(Seats.Upholstery.LEATHER)
                    ),
                    wheelFactory = Wheel.WheelFactory(Wheel.Type.STEEL)
                ),
                engine = Engine(
                    Engine.Type.DIESEL,
                    Transmission(Transmission.Type.FWD)
                )
            )

            val ecoSport = Vehicle(
                wheelBase = WheelBase(
                    WheelBase.Size.SMALL,
                    Chasis(
                        Chasis.Type.SUV,
                        seatFactory = Seats.SeatFactory(Seats.Upholstery.REXINE)
                    ),
                    wheelFactory = Wheel.WheelFactory(Wheel.Type.ALLOY),
                    spareWhee = true
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