package strategy.processor

interface Processor<D> {
    fun process(definition: D): ProcessorOutput
}