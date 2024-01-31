package strategy.skeleton

data class YamlTestSkeleton(
    val testVectors: Map<String, TypeSchema>? = null,
)

data class TypeSchema(
    val title: String? = null,
    val description: String? = null,
    val type: String? = null,
    val maxSpeed: Int? = null,
)