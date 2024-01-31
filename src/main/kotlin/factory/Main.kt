package factory

import factory.factory.CarFactory
import factory.factory.Engine
import factory.factory.Factory.getCarType

fun main(args: Array<String>) {
    val sportCar: CarFactory? = getCarType("Sport")
    val sportEngine: Engine = sportCar!!.createEngine()
    println("Horse power of sport car: " + sportEngine.getHorsePower())
}