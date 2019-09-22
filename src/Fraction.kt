import kotlin.math.absoluteValue

data class Fraction(
    var whole: Int,
    var numerator: Int,
    var denominator: Int
) {
    operator fun plus(other: Fraction): Fraction {
        val (numeratorA, denominatorA) = this.toImproper()
        val (numeratorB, denominatorB) = other.toImproper()
        val result = numeratorA * denominatorB + numeratorB * denominatorA to denominatorA * denominatorB
        return result.toMixedFraction()
    }

    operator fun minus(other: Fraction): Fraction {
        val (numeratorA, denominatorA) = this.toImproper()
        val (numeratorB, denominatorB) = other.toImproper()
        val result = numeratorA * denominatorB - numeratorB * denominatorA to denominatorA * denominatorB
        return result.toMixedFraction()
    }

    operator fun div(other: Fraction): Fraction {
        val (numeratorA, denominatorA) = this.toImproper()
        val (numeratorB, denominatorB) = other.toImproper()
        val result = numeratorA * denominatorB to denominatorA * numeratorB
        return result.toMixedFraction()
    }

    operator fun times(other: Fraction): Fraction {
        val (numeratorA, denominatorA) = this.toImproper()
        val (numeratorB, denominatorB) = other.toImproper()
        val result = numeratorA * numeratorB to denominatorA * denominatorB
        return result.toMixedFraction()
    }

    /**
     * Creates a representation of the fraction as it is expected to be displayed to the user
     */
    override fun toString(): String = with(StringBuilder()) {
        if (whole != 0) {
            append(whole)
            if (numerator != 0 && denominator != 0) {
                append("_")
            }
        }
        if (numerator != 0 && denominator != 0) {
            append("$numerator/$denominator")
        }
        toString()
    }

    /**
     * Creates an improper fraction from a `Fraction` object in oder to make the operations straightforward
     */
    private fun toImproper(): Pair<Int, Int> = if (denominator != 0) {
        whole * denominator + numerator to denominator
    } else {
        whole to 1
    }

    /**
     * Turns an improper fraction into the most simplified version of a `Fragment` object that could represent it
     */
    private fun Pair<Int, Int>.toMixedFraction(): Fraction {
        val gdc = greatestCommonDenominator(first, second)
        val simplifiedFraction = first / gdc to second / gdc
        val whole = simplifiedFraction.first / simplifiedFraction.second
        val numerator = simplifiedFraction.first % simplifiedFraction.second
        val absNumerator = if(whole < 0 && numerator < 0) numerator.absoluteValue else numerator
        return Fraction(whole, absNumerator, simplifiedFraction.second)
    }

    /**
     * Calculates the biggest common denominator through the euclidean algorithm in order to simplify the fractions
     */
    private fun greatestCommonDenominator(a: Int, b: Int): Int {
        return if (b == 0) a else greatestCommonDenominator(b, a % b)
    }
}