fun main() {
    while (true) {
        println("Enter a Fraction operation or `q` to quit")
        val line = readLine()?.trim()
        if(line.equals("q")) {
            return
        }
        val operation = OperationParser.fromString(line)
        val result = operation?.let {
            val resultFraction = it.performOperation()
            "The result is: $resultFraction\n"
        } ?: "Invalid fraction\n"
        println(result)
    }
}