package factory.factory

class SportCarFactory : CarFactory {
    override fun createEngine(): SportEngine {
        return SportEngine()
    }
    override fun createSuspension(): Suspension {
        return SportSuspension()

    }
    override fun createBody(): Body {
        return SportBody()
    }
}

class SportEngine: Engine {
    override fun getHorsePower(): Int {
        return 350
    }
}

class SportSuspension: Suspension {
    override fun getStiffening(): Stiffening {
        return Stiffening.HARD
    }
}
class SportBody: Body {
    override fun getWeight(): Int {
        return 1100
    }
}
