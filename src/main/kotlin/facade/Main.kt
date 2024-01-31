package facade

import org.example.facade.CarFacade.CarFacade
import facade.components.Engine
import facade.components.FuelInjector
import facade.components.Lights
import facade.components.Suspension

fun main() {

    val engine = Engine()
    val lights = Lights()
    val fuelInjector = FuelInjector()
    val suspension = Suspension()

    val carFacade = CarFacade(engine, lights, fuelInjector, suspension)

    carFacade.startCar()
    println("Driving...")
    carFacade.stopCar()
}
