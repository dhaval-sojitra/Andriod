//23. Write a program to find maximum number from 2 numbers

fun main() {
    print("Enter Number 1 : ")
    var n1 = readLine()!!.toInt()
    print("Enter Number 2 : ")
    var n2 = readLine()!!.toInt()

    println("---------------------------------------")
    if(n1==n2){
        println("Both are same..")
    }
    else if(n1>n2){
        println("Number 1 is maximum number..")
    }
    else{
        println("Number 2 is maximum number..")
    }
}