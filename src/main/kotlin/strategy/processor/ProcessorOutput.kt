package strategy.processor

data class ProcessorOutput(
    val type: String,
    val description: String? = null,
) {
    init {
        println("$type is processed for object with description: \n\"$description\"")
    }
}