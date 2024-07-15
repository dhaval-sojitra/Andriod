
abstract class Shiva {
    fun lordshiva(){
        println("Devo ke dev mahadev!!!");
    }
    abstract fun prayer()
}
class Rama : Shiva(){
    override fun prayer() {
        println("Rama's Prayer")
    }
}
class Krishna : Shiva(){
    override fun prayer() {
        println("Kirshna's Prayer")
    }
}
fun main() {
    var s : Shiva = Rama()
    s.prayer()
    s.lordshiva()
    s = Krishna()
    s.prayer()
    s.lordshiva()

}