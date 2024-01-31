package strategy.strategies

import strategy.processor.Processor
import strategy.processor.ProcessorOutput
import strategy.processor.TypeProcessorStrategy
import strategy.skeleton.TypeSchema

class SportCarProcessorStrategy : TypeProcessorStrategy {
    override fun matches(definition: TypeSchema): Boolean {
        return definition.type == "fast car" &&
            definition.maxSpeed!! > 140
    }

    override fun process(
        definition: TypeSchema,
        processor: Processor<TypeSchema>
    ): ProcessorOutput {
        val type = "Sport car as " + definition.type
        val description = definition.description
        return ProcessorOutput(type, description)
    }
}
