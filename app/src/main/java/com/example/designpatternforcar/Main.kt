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

            val wheelBaseSize: WheelBase.Size = TermUi.prompt(
                "Enter wheel base size: (S)mall, (M)edium or (L)arge"
            ) {
                when (it) {
                    "S", "s" -> WheelBase.Size.SMALL
                    "M", "m" -> WheelBase.Size.MEDIUM
                    "L", "l" -> WheelBase.Size.LARGE
                    else -> throw UsageError("Size has to be (S)mall, (M)edium or (L)arge")
                }
            }!!

            val chasisType: Chasis.Type = TermUi.prompt(
                "Enter chasis type : (H)atchback, (S)edan, SU(V) or (P)ickup"
            ) {
                when (it) {
                    "H", "h" -> Chasis.Type.HATCHBACK
                    "S", "s" -> Chasis.Type.SEDAN
                    "V", "v" -> Chasis.Type.SUV
                    "P", "p" -> Chasis.Type.PICKUP
                    else -> throw UsageError("Chasis type has to be (H)atchback, (S)edan, SU(V) or (P)ickup")
                }
            }!!

            val seatType: Seats.Upholstery =
                TermUi.prompt("Enter seat type : (C)loths, (R)exine or (L)eather") {
                    when (it) {
                        "C", "c" -> Seats.Upholstery.CLOTHS
                        "R", "r" -> Seats.Upholstery.REXINE
                        "L", "l" -> Seats.Upholstery.LEATHER
                        else -> throw UsageError("Seat type has to be  (C)loths, (R)exine or (L)eather")
                    }
                }!!

            val wheelType: Wheel.Type =
                (TermUi.prompt("Enter wheel type : (S)teel, (A)lloy or (C)arbonfibre") {
                    when (it) {
                        "S", "s" -> Wheel.Type.STEEL
                        "A", "a" -> Wheel.Type.ALLOY
                        "C", "c" -> Wheel.Type.CARBONFIBRE
                        else -> UsageError("Wheel type has to be (S)teel, (A)lloy or (C)arbonfibre")
                    }
                } as Wheel.Type?)!!

            val engineType: Engine.Type =
                TermUi.prompt("Enter engine type : (P)etrol, (D)iesel, (H)ybrid or (E)lectric") {
                    when (it) {
                        "P", "p" -> Engine.Type.PETROL
                        "D", "d" -> Engine.Type.DIESEL
                        "H", "h" -> Engine.Type.HYBRID
                        "E", "e" -> Engine.Type.ELECTRIC
                        else -> UsageError("Engine type has to be (P)etrol, (D)iesel, (H)ybrid or (E)lectric")
                    }
                } as Engine.Type

            val transmissionType: Transmission.Type =
                TermUi.prompt("Enter transmission type : (R)WD, (F)WD or (A)WD") {
                    when (it) {
                        "R", "r" -> Transmission.Type.RWD
                        "F", "f" -> Transmission.Type.FWD
                        "A", "a" -> Transmission.Type.AWD
                        else -> UsageError("Transmission type has to be (R)WD, (F)WD or (A)WD")
                    }
                } as Transmission.Type

            val vehiclePrice: Vehicle = Vehicle(
                wheelBase = WheelBase(
                    wheelBaseSize,
                    Chasis(
                        chasisType,
                        Seats.SeatFactory(seatType)
                    ),
                    wheelFactory = Wheel.WheelFactory(wheelType)
                ),
                engine = Engine(
                    engineType,
                    Transmission(transmissionType)
                )
            )

            println("Your selected vehicle price is = ${vehiclePrice.price}")

        }
    }
}