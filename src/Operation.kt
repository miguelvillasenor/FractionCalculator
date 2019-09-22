enum class Operand(val symbol: String) {
    ADD("+"),
    SUBTRACT("-"),
    DIVIDE("/"),
    MULTIPLY("*")
}

fun Operand.fromString(operand: String) = Operand.values().firstOrNull { it.symbol == operand }

data class Operation(
    val left: Fraction,
    val right: Fraction,
    val operand: Operand
)