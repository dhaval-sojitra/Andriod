//34. Write a program input one integer number display appropriate day of week.
fun main() {
    print("Enter Any Number : ")
    var num = readLine()!!.toInt()

    when(num){
        1 -> println("Sunday")
        2 -> println("Monday")
        3 -> println("Tuesday")
        4 -> println("Wednesday")
        5 -> println("Thruesday")
        6 -> println("Friday")
        7 -> println("Saturday")
        else -> println("Enter Valid Number...")
    }
}