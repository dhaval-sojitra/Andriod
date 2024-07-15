//42. Write a program that reads a sales bill amount calculate discount on bill amount asfollows
//if bill amount less than 5000 calculate 7.5% discount on bill amount otherwise calculate11%
//discount on bill. Print bill amount discount amount and net payable bill

fun main() {
    print("Enter Total Amount : ")
    var amount = readLine()!!.toDouble()
    var discount : Double = 0.0
    println("---------------BILL---------------")
    println("Total Amount : $amount")
    if(amount < 5000){
        discount = (amount*7.5)/100
        println("Discount 7.5% : $discount")
    }
    else{
        discount = (amount*11)/100
        println("Discount 11% : $discount")
    }
    println("Payble Amount : ${amount-discount}")

}