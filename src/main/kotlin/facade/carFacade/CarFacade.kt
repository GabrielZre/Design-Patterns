package org.example.facade.CarFacade

import facade.components.Engine
import facade.components.FuelInjector
import facade.components.Lights
import facade.components.Suspension

class CarFacade(private val engine: Engine, private val lights: Lights, private val fuelInjector: FuelInjector, private val suspension: Suspension) {
    fun startCar() {
        engine.start()
        lights.turnOn()
        fuelInjector.inject()
        suspension.turnOnAdaptiveSystem()
        println("Car started")
    }

    fun stopCar() {
        engine.stop()
        lights.turnOff()
        fuelInjector.stopInjection()
        suspension.turnOffAdaptiveSystem()
        println("Car stopped")
    }
}
