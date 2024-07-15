//14. Write a program to swap two values without using third variable

fun main() {
    var val1 =25
    var val2 = 50

    println("Value 1 Before Swapping : $val1")
    println("Value 2 Before Swapping : $val2")

    val1 = val1 + val2
    val2 = val1 - val2
    val1 = val1 - val2

    println("Value 1 After Swapping : $val1")
    println("Value 2 After Swapping : $val2")}