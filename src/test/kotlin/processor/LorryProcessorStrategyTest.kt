package processor

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import strategy.strategies.LorryProcessorStrategy

class LorryProcessorStrategyTest {

    private val target = LorryProcessorStrategy()

    @Test
    fun matches_passesLorryExample() {
        val testVector = generalTestVectorDefinitions[LORRY_STRATEGY_TEST_VECTOR]!!

        assertTrue(target.matches(testVector))
    }

    @Test
    fun matches_failsNonLorryExamples() {
        generalTestVectorDefinitions
            .filter { it.key != LORRY_STRATEGY_TEST_VECTOR }
            .forEach { (_, def) -> assertFalse(target.matches(def)) }
    }

    @Test
    fun process_processAllTypes() {
        val testVector = generalTestVectorDefinitions[LORRY_STRATEGY_TEST_VECTOR]!!

        val (type, description,) = target.process(testVector, allTypesProcessor)

        assertEquals("Lorry as slow car", type)
        assertEquals("example of lorry", description)
    }
}
