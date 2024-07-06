import java.lang.NumberFormatException

fun main(){
    print("Enter Readuis of Circle : ")
        val r : Float = readln()!!.toFloat()
        val pi : Float = 3.14f
        print("Area of Circle :${r * r * pi}")
    if (r.toString().isNotEmpty()) {
        val r2 : Float = r.toFloat()
        print("Area of Circle :${r2 * r2 * pi}")
    }
    else
        print("Enter Value")
//    try {
//
//    }
//    catch(e: NumberFormatException)
//    {
//        print("Enter Value : ${e.message}")
//    }
}
