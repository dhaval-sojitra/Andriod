//32. Write a program input one integer number check whether number is four digits or not

fun main() {
    print("Enter any number : ")
    val num = readLine()!!.toInt()
    var count = 0;
    var temp = num
    var n = 0
    while(temp!=0){
        n = temp%10
        count++
        temp/=10
    }
    if(count==4){
        println("Given number is four digit number...")
    }
    else{
        println("Given number is not four digit number...")
    }
}