# Build and Run

## Requirements
In order to run the project you need to have Kotlin Compiler installed on your system, you can follow the directions in:

[Kotlin compiler documentation](https://kotlinlang.org/docs/tutorials/command-line.html)

If you only want to build run the project and not build it, I included a `.jar` file with the latest version of the code, and the only requirement to run it is to have the JVM.


## Building
After installing kotlin compiler you can build the project by running `build.sh` this will generate a `.jar` file that can be run with the JVM.

## Running
As a shortcut to run it you can use `./run.sh`, and in case that you don't want to install the kotlin compiler.

# Functionality

This program has the capacity of solving the following fraction arithmetic operations: multiply, divide, add, subtract.

When you run the program you will see the following prompt: `Enter a Fraction operation or 'q' to quit`.

In order to perform an operation the program expects an input with the following format: `<operand> <operator> <operand>`.

The operands should have the following format `whole_numerator/denominator`, `whole` is required when we don't have a `numerator/denominator` and the other way around.

The valid operators are `+`, `-`, `/`, and `*`

## Example

```
Enter a Fraction operation or `q` to quit
20/40 + 3_1/2* // This is the format of the expected user input 
The result is: 4

Enter a Fraction operation or `q` to quit
q
``` 

