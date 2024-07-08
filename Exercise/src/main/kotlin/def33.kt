//33. Write a program input one integer number check whether is greater than 50 and lessthen
//200

fun main() {
    print("Enter any number : ")
    val num = readLine()!!.toInt()

    if(num in 50..200){
        println("Given number is greater than 50 and lessthen 200")
    }
    else{
        println("Given number is not greater than 50 and lessthen 200")
    }
}