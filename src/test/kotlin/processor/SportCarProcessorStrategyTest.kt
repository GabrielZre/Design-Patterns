package processor

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import strategy.strategies.SportCarProcessorStrategy

class SportCarProcessorStrategyTest {

    private val target = SportCarProcessorStrategy()

    @Test
    fun matches_passesSportCarExample() {
        val testVector = generalTestVectorDefinitions[SPORT_CAR_STRATEGY_TEST_VECTOR]!!

        assertTrue(target.matches(testVector))
    }

    @Test
    fun matches_failsNonSportCarExamples() {
        generalTestVectorDefinitions
            .filter { it.key != SPORT_CAR_STRATEGY_TEST_VECTOR }
            .forEach { (_, def) -> assertFalse(target.matches(def)) }
    }

    @Test
    fun process_processAllTypes() {
        val testVector = generalTestVectorDefinitions[SPORT_CAR_STRATEGY_TEST_VECTOR]!!

        val (type, description) = target.process(testVector, allTypesProcessor)

        assertEquals("Sport car as fast car", type)
        assertEquals("example of sport car", description)
    }
}
