interface myInterface {
    val test : Int
    fun foo() : String
    fun hello(){
        println("Hello Everyone!!!")
    }
}
class  interfaceimp : myInterface
{
        override val test = 100
        override fun foo() = "MCA"
}
fun main() {
    var obj = interfaceimp()
    println("Test = ${obj.test}")
    println(obj.foo())
    obj.hello()
}