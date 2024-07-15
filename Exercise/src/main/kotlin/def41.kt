//41. Write a program to find number which number is divisible by 3 but not divisible by 7
fun main() {
    print("Enter Any Number : ")
    var num = readLine()!!.toInt()

    if(num%3==0 && num%7==0){
        println("Given number $num is divisible by 3 and 7")
    }
    else if(num%3==0 && num%7!=0){
        println("Given number $num is divisible by 3 but not 7")
    }
    else{
        println("Given Number is not divisible by 3 or 7")
    }
}