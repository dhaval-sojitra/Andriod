//38. Enter age of person and display message as
//Up to 5 year Kid
//5- 12 Children
//13 – 19 Teenager
//20 – 30 Young
//31 – 60 Mid age group
//60 or above Old

fun main() {
    print("Enter Your Age : ")
    var age = readLine()!!.toInt()

    if(age<5){
        println("Kid...")
    }
    else if(age<=12){
        println("Children...")
    }
    else if(age<=19){
        println("Teenager...")
    }
    else if(age<=30){
        println("Young...")
    }
    else if(age<=60){
        println("Mid age group...")
    }
    else{
        println("Old")
    }
}