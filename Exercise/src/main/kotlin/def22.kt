//22. Write a program to find out the net salary of an employee and get the basic salary from him.
//Applicable TA 4%, DA 30%, HRA 15% on basic salary. Applicable 3% tax 12% PF on basic salary

fun main() {
    print("Enter your basic salary : ")
    var sal = readLine()!!.toDouble()
    println("Your basic salary : $sal")
    var ta : Double= (sal*4)/100
    println("TA : $ta")
    var da : Double= (sal*30)/100
    println("DA : $da")
    var hra : Double= (sal*15)/100
    println("HRA : $hra")
    var tax : Double= (sal*3)/100
    println("TAX : $tax")
    var pf : Double= (sal*12)/100
    println("PF : $pf")

    var netsal : Double = sal+ta+da+hra-tax-pf
    println("------------------------------------------------")
    println("Net Salary : $netsal")
}