fun main() {
    var neverNull : String = "This can't be Null"

    var nullable : String ? = "You can keep null"
    nullable = null

    var  inferredNonNull = "The compliler Assums not null"

    println(strLength(neverNull))
    println(strLength(nullable))
}
fun strLength(notNull : String?) : Int?{
    return notNull?.length
}