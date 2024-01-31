package factory.factory

interface CarFactory {
    fun createEngine(): Engine
    fun createSuspension(): Suspension
    fun createBody(): Body
}

interface Engine {
    fun getHorsePower() : Int
}
interface Suspension {
    fun getStiffening() : Stiffening
}
interface Body {
    fun getWeight() : Int
}

enum class Stiffening() {
    SOFT,
    NORMAL,
    HARD
}

object Factory {
    fun getCarType(carType: String): CarFactory? {
        return when (carType) {
            "Sport" -> SportCarFactory()
            "City" -> CityCarFactory()
            else -> null
        }
    }
}

