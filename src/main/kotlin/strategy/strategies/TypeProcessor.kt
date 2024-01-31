package strategy.strategies

import strategy.skeleton.TypeSchema
import strategy.exceptions.ProcessionError
import strategy.processor.Processor
import strategy.processor.ProcessorOutput
import strategy.processor.TypeProcessorStrategy
import java.util.*

class TypeProcessor(private val strategies: List<TypeProcessorStrategy>) : Processor<TypeSchema> {

    val output = ArrayList<ProcessorOutput>()

    override fun process(definition: TypeSchema): ProcessorOutput {
        val selectedStrategies = strategies.filter { it.matches(definition) }

        if (selectedStrategies.isEmpty()) {
            throw ProcessionError("Processor strategy not found! Definition: $definition")
        }

        if (selectedStrategies.size > 1) {
            throw ProcessionError(
                "Found ${selectedStrategies.size} conflicting strategies. Check matching for both of them: \n " +
                        selectedStrategies.joinToString(", ") { it.toString() }
            )
        }

        val generated = selectedStrategies.first().process(definition, this)
        output.add(generated)
        return generated
    }
}