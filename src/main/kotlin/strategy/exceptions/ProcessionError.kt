package strategy.exceptions

class ProcessionError(message: String, cause: Throwable? = null) : Exception(message, cause)
