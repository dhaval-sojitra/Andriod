//13. Write a program to swap two values

fun main() {
    var val1 =25
    var val2 = 50

    println("Value 1 Before Swapping : $val1")
    println("Value 2 Before Swapping : $val2")

    var temp = val1
    val1 = val2
    val2 = temp

    println("Value 1 After Swapping : $val1")
    println("Value 2 After Swapping : $val2")
}