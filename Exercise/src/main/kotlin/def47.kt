//47. Write a program that accept character from keyboard and determine whether the
//character is a capital letter, small letter, digit or a special character

fun categorizeCharacter(char: Char): String {
    return when {
        char.isUpperCase() -> "Capital letter"
        char.isLowerCase() -> "Small letter"
        char.isDigit() -> "Digit"
        else -> "Special character"
    }
}

fun main() {
    print("Enter a character: ")
    val input = readLine()

    if (input.isNullOrEmpty() || input.length != 1) {
        println("Please enter exactly one character.")
    } else {
        val char = input[0]
        val category = categorizeCharacter(char)
        println("The character '$char' is a $category.")
    }
}
