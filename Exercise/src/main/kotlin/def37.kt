//37. Write a program to find out minimum from three number

fun main() {
    print("Enter Number 1 : ")
    var n1 = readLine()!!.toInt()
    print("Enter Number 2 : ")
    var n2 = readLine()!!.toInt()
    print("Enter Number 3 : ")
    var n3 = readLine()!!.toInt()

    if(n1<n2 && n1<n3){
        println("$n1 is Minimum Number...")
    }
    else if(n2<n1 && n2<n3){
        println("$n2 is Minimum Number...")
    }
    else{
        println("$n3 is Minimum Number...")
    }
}