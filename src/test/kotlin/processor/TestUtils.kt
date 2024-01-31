package processor

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import strategy.skeleton.YamlTestSkeleton
import strategy.strategies.LorryProcessorStrategy
import strategy.strategies.SportCarProcessorStrategy
import strategy.strategies.TypeProcessor

val LORRY_STRATEGY_TEST_VECTOR = "LorryExample"
val SPORT_CAR_STRATEGY_TEST_VECTOR = "SportCarExample"
val TYPES_TEST_VECTORS_PATH = "/types-test-vectors.yml"

val generalTestVectors =
    YAMLFactory::class.java.getResource(TYPES_TEST_VECTORS_PATH)?.readText()

private fun createObjectMapper(): ObjectMapper {
    val mapper = ObjectMapper(YAMLFactory())
    val module = SimpleModule()
    mapper.registerModule(module)

    return mapper
}

private val om = createObjectMapper()

val generalTestVectorDefinitions =
    om.readValue(generalTestVectors, YamlTestSkeleton::class.java).testVectors!!

val allTypesProcessor = prepareAllTypesProcessor()

private fun prepareAllTypesProcessor(): TypeProcessor {
    val strategies =
        listOf(
            SportCarProcessorStrategy(),
            LorryProcessorStrategy()
        )

    return TypeProcessor(strategies)
}
