package com.example.designpatternforcar.vehicle.parts

class Engine private constructor(
    private val type: Type,
    private val transmission: Transmission
) : Parts {

    override val selfPrice: Int
        get() = when (type) {
            Type.PETROL -> 100000
            Type.DIESEL -> 200000
            Type.HYBRID -> 500000
            Type.ELECTRIC -> 400000
        }

    override val totalCost: Int
        get() = selfPrice + transmission.totalCost

    enum class Type { PETROL, DIESEL, HYBRID, ELECTRIC }

    class Builder {
        lateinit var engineType: Type
        lateinit var transmissionType: Transmission

        fun setEngineType(type: Type): Builder {
            this.engineType = type
            return this
        }

        fun setTransmission(transmission: Transmission): Builder {
            this.transmissionType = transmission
            return this
        }

        fun build(): Engine {
            return Engine(this.engineType, this.transmissionType)
        }
    }
}