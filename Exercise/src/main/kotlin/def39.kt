//39. Write a program input integer number and select number to perform following task
//1 – Addition
//2 – Subtraction
//3 – Multiplication
//4 – Division
//5 – Exit

fun main() {
    do{
        println("-------------------------------------------")
        println("Enter 1 For Addition...")
        println("Enter 2 For Subtraction...")
        println("Enter 3 For Multiplication...")
        println("Enter 4 For Division...")
        println("Enter 5 For Exit...")
        println("-------------------------------------------")
        print("Enter Your Choice : ")
        var res = readLine()!!.toInt()
        if(res == 5 ){
            println("Good By!!")
            break
        }
        print("Enter Number 1 :")
        var n1 = readLine()!!.toInt()
        print("Enter Number 2 :")
        var n2 = readLine()!!.toInt()
        when(res){
            1 -> println("Additon $n1 + $n2 : ${n1+n2}")
            2 -> println("Subtraction $n1 - $n2 : ${n1-n2}")
            3 -> println("Multiplication $n1 X $n2 : ${n1*n2}")
            4 -> println("Division $n1 / $n2 : ${n1/n2}")
            else -> println("Please enter valid choice...")
        }
    }while(res!=5)

}