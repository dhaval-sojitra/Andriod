//21. Write a program that accept 5 numbers from user and find average of the value

fun main() {
    print("Enter Number 1 : ")
    var n1 = readLine()!!.toInt()
    print("Enter Number 2 : ")
    var n2 = readLine()!!.toInt()
    print("Enter Number 3 : ")
    var n3 = readLine()!!.toInt()
    print("Enter Number 4 : ")
    var n4 = readLine()!!.toInt()
    print("Enter Number 5 : ")
    var n5 = readLine()!!.toInt()

    println("-------------------------------------------------------")
    println("Average of given Numbers : ${(n1+n2+n3+n4+n5)/5}")

}