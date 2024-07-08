//20. Write a program to convert negative to positive and positive to negative
fun main() {
    print("Enter Any Positive or Nagative Number : ")
    var num = readLine()!!.toInt()

    if(num>0){
        println("Positive to Nagative : ${-num}")
    }
    else{
        println("Nagative to Positve : ${-num}")
    }
}