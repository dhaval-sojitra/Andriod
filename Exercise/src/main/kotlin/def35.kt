//35. Write a program input one integer number display appropriate name of month
fun main() {
    print("Enter Any Number : ")
    var num = readLine()!!.toInt()

    when(num){
        1 -> println("January")
        2 -> println("February")
        3 -> println("March")
        4 -> println("April")
        5 -> println("May")
        6 -> println("June")
        7 -> println("July")
        8 -> println("August")
        9 -> println("September")
        10 -> println("Octomber")
        11 -> println("November")
        12 -> println("December")
        else -> println("Enter Valid Number...")
    }
}