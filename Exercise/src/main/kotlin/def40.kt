//40. Write a program input 5 subject marks and find class and result

fun main() {
    print("Enter Student Name : ")
    var name = readLine()
    print("Enter Subject 1 Marks : ")
    var s1 = readLine()!!.toInt()
    print("Enter Subject 2 Marks : ")
    var s2 = readLine()!!.toInt()
    print("Enter Subject 3 Marks : ")
    var s3 = readLine()!!.toInt()
    print("Enter Subject 4 Marks : ")
    var s4 = readLine()!!.toInt()
    print("Enter Subject 5 Marks : ")
    var s5 = readLine()!!.toInt()

    println("----------------------------------------------")
    println("Name : $name")
    println("Subject 1 : $s1")
    println("Subject 2 : $s2")
    println("Subject 3 : $s3")
    println("Subject 4 : $s4")
    println("Subject 5 : $s5")

    var tot = s1+s2+s3+s4+s5
    var per : Float= tot/5f
    println("----------------------")
    println("Total : $tot")
    if(s1<40 || s2<40 || s3<40 || s4<40 || s5<40){
        println("Result : Fail")
        println("Percentage : **")
        println("Class : Fail")
    }
    else{
        println("Result : Pass")
        println("Percentage : $per")
        if(per>=75){
            println("Class : Distinction")
        }
        else if(per>=60){
            println("Class : First")
        }
        else if(per>=50){
            println("Class : Second")
        }
        else{
            println("Class : Pass")
        }
    }
    println("----------------------------------------------")
}