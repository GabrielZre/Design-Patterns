package strategy.processor

import strategy.skeleton.TypeSchema

interface ProcessorStrategy<D, G> {
    fun matches(definition: D): Boolean

    fun process(definition: D, processor: Processor<G>): ProcessorOutput
}

typealias TypeProcessorStrategy = ProcessorStrategy<TypeSchema, TypeSchema>
