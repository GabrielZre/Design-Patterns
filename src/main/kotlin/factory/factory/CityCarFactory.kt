package factory.factory

class CityCarFactory : CarFactory {
    override fun createEngine(): Engine {
        return CityEngine()
    }
    override fun createSuspension(): Suspension {
        return CitySuspension()

    }
    override fun createBody(): Body {
        return CityBody()
    }

    class CityEngine: Engine {
        override fun getHorsePower(): Int {
            return 75
        }
    }

    class CitySuspension: Suspension {
        override fun getStiffening(): Stiffening {
            return Stiffening.SOFT
        }
    }
    class CityBody: Body {
        override fun getWeight(): Int {
            return 900
        }
    }
}