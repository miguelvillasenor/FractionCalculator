object OperationParser {
    private val spacesRegex = "\\s+".toRegex()
    private val allowedOperands = Operand.values().map { it.symbol }

    /**
     * Parses the user input into an Operation object, in case that the input of the user is invalid, we will return null
     */
    fun fromString(string: String?): Operation? {
        val values = string?.replace(spacesRegex, " ")?.split(" ")
        if (values == null || values.size != 3 || values[1] !in allowedOperands) {
            return null
        }
        return try {
            val left = parseFraction(values[0])
            val right = parseFraction(values[2])
            Operation(left, right, values[1].toOperand()!!)
        } catch (exception: java.lang.NumberFormatException) {
            null
        }
    }

    @Throws(NumberFormatException::class)
    private fun parseFraction(string: String): Fraction {
        val whole = getWhole(string)
        val (numerator, denominator) = getFraction(string)
        return Fraction(whole, numerator, denominator)
    }

    private fun getWhole(string: String): Int = when {
        string.contains("_") -> string.split("_").first().toInt()
        !string.contains("/") -> string.toInt()
        else -> 0
    }


    private fun getFraction(string: String): Pair<Int, Int> {
        val fractionSegment = if (string.contains("_")) {
            string.split("_")[1]
        } else {
            string
        }
        return if (fractionSegment.contains("/")) {
            val segments = fractionSegment.split("/")
            segments[0].toInt() to segments[1].toInt()
        } else {
            0 to 0
        }
    }

    private fun String.toOperand() = Operand.values().firstOrNull { it.symbol == this }
}