package strategy.strategies

import strategy.processor.Processor
import strategy.processor.ProcessorOutput
import strategy.skeleton.TypeSchema
import strategy.processor.TypeProcessorStrategy

class LorryProcessorStrategy : TypeProcessorStrategy {
    override fun matches(definition: TypeSchema): Boolean {
        return definition.type == "slow car" &&
            definition.maxSpeed!! < 140
    }

    override fun process(
        definition: TypeSchema,
        processor: Processor<TypeSchema>
    ): ProcessorOutput {
        val type = "Lorry as " + definition.type
        val documentation = definition.description

        return ProcessorOutput(type, documentation)
    }
}
