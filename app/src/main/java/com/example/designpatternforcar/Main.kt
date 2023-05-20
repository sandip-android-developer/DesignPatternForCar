package com.example.designpatternforcar

import com.example.designpatternforcar.vehicle.Vehicle
import com.example.designpatternforcar.vehicle.parts.Chasis
import com.example.designpatternforcar.vehicle.parts.Engine
import com.example.designpatternforcar.vehicle.parts.Transmission
import com.example.designpatternforcar.vehicle.parts.WheelBase
import com.example.designpatternforcar.vehicle.parts.seats.Seats
import com.example.designpatternforcar.vehicle.parts.wheel.Wheel
import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.output.TermUi

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                """
                | ------ Welcome to car picker 1.0 ------
                | Here you can build your very own car, with 
                | with everything fully customisable. Fell free
                | to pick engine, seats, wheel etc.
            """.trimIndent()
            )

            if (TermUi.confirm("Continue to build card ?") != true) {
                return
            }

            val wheelBaseBuilder = WheelBase.Builder()

            TermUi.prompt(
                "Enter wheel base size: (S)mall, (M)edium or (L)arge"
            ) {
                when (it) {
                    "S", "s" -> wheelBaseBuilder.setWheelBaseSize(WheelBase.Size.SMALL)
                    "M", "m" -> wheelBaseBuilder.setWheelBaseSize(WheelBase.Size.MEDIUM)
                    "L", "l" -> wheelBaseBuilder.setWheelBaseSize(WheelBase.Size.LARGE)
                    else -> throw UsageError("Size has to be (S)mall, (M)edium or (L)arge")
                }
            }!!

            val chasisBuilder = Chasis.Builder()

            TermUi.prompt(
                "Enter chasis type : (H)atchback, (S)edan, SU(V) or (P)ickup"
            ) {
                when (it) {
                    "H", "h" -> chasisBuilder.setChasisType(Chasis.Type.HATCHBACK)
                    "S", "s" -> chasisBuilder.setChasisType(Chasis.Type.SEDAN)
                    "V", "v" -> chasisBuilder.setChasisType(Chasis.Type.SUV)
                    "P", "p" -> chasisBuilder.setChasisType(Chasis.Type.PICKUP)
                    else -> throw UsageError("Chasis type has to be (H)atchback, (S)edan, SU(V) or (P)ickup")
                }
            }!!

            TermUi.prompt("Enter seat type : (C)loths, (R)exine or (L)eather") {
                when (it) {
                    "C", "c" -> chasisBuilder.setSeatFactory(Seats.SeatFactory(Seats.Upholstery.CLOTHS))
                    "R", "r" -> chasisBuilder.setSeatFactory(Seats.SeatFactory(Seats.Upholstery.REXINE))
                    "L", "l" -> chasisBuilder.setSeatFactory(Seats.SeatFactory(Seats.Upholstery.LEATHER))
                    else -> throw UsageError("Seat type has to be  (C)loths, (R)exine or (L)eather")
                }
            }!!

            TermUi.prompt("Enter wheel type : (S)teel, (A)lloy or (C)arbonfibre") {
                when (it) {
                    "S", "s" -> wheelBaseBuilder.setWheelFactory(Wheel.WheelFactory(Wheel.Type.STEEL))
                    "A", "a" -> wheelBaseBuilder.setWheelFactory(Wheel.WheelFactory(Wheel.Type.ALLOY))
                    "C", "c" -> wheelBaseBuilder.setWheelFactory(Wheel.WheelFactory(Wheel.Type.CARBONFIBRE))
                    else -> UsageError("Wheel type has to be (S)teel, (A)lloy or (C)arbonfibre")
                }
            }
            val engineBuilder = Engine.Builder()
            TermUi.prompt("Enter engine type : (P)etrol, (D)iesel, (H)ybrid or (E)lectric") {
                when (it) {
                    "P", "p" -> engineBuilder.setEngineType(Engine.Type.PETROL)
                    "D", "d" -> engineBuilder.setEngineType(Engine.Type.DIESEL)
                    "H", "h" -> engineBuilder.setEngineType(Engine.Type.HYBRID)
                    "E", "e" -> engineBuilder.setEngineType(Engine.Type.ELECTRIC)
                    else -> UsageError("Engine type has to be (P)etrol, (D)iesel, (H)ybrid or (E)lectric")
                }
            }

            TermUi.prompt("Enter transmission type : (R)WD, (F)WD or (A)WD") {
                when (it) {
                    "R", "r" -> engineBuilder.setTransmission(Transmission(Transmission.Type.RWD))
                    "F", "f" -> engineBuilder.setTransmission(Transmission(Transmission.Type.FWD))
                    "A", "a" -> engineBuilder.setTransmission(Transmission(Transmission.Type.AWD))
                    else -> UsageError("Transmission type has to be (R)WD, (F)WD or (A)WD")
                }
            }
            val myCar = Vehicle.Builder()
                .setEngine(engineBuilder.build())
                .setWheelBase(wheelBaseBuilder.build())
                .setChasis(chasisBuilder.build())
                .build()

            println("Your selected vehicle price is = ${myCar.price}")

        }
    }
}