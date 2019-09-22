enum class Operand(val symbol: String) {
    ADD("+"),
    SUBTRACT("-"),
    DIVIDE("/"),
    MULTIPLY("*")
}

data class Operation(
    val left: Fraction,
    val right: Fraction,
    val operand: Operand
) {
    fun performOperation(): String = when (operand) {
        Operand.ADD -> (left + right).toString()
        Operand.SUBTRACT -> (left - right).toString()
        Operand.DIVIDE -> (left / right).toString()
        Operand.MULTIPLY -> (left * right).toString()
    }

}