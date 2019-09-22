fun main(args: Array<String>) {
    while (true) {
        println("Enter a Fraction operation or `q` to quit")
        val line = readLine()?.trim()
        if(line.equals("q")) {
            return
        }
        val operation = OperationParser.fromString(line)
        val result = operation?.let {
            println(operation)
            "The result is\n"
        } ?: "Invalid fraction\n"


        println(result)
    }
}