//8. The distance between two cities is input through keyboard. Write a program to convertand print
//this distance in feet, meter, inch and centimeter

fun main() {
    print("Enter Distance between two cities in kilometer : ")
    var dis = readLine()!!.toDouble()

    println("Distance in Feet : ${dis*3280.84}")
    println("Distance in Meter : ${dis*1000}")
    println("Distance in Inch : ${dis*39370.1}")
    println("Distance in Centimeter : ${dis*100000}")
}