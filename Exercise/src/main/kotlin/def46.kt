//46. Get a string from user and check it is vowel or consonants

fun main() {
    print("Enter Any Character : ")
    var ch = readLine() ?: ""
    ch = ch.toLowerCase()

    if(ch=="a" || ch=="e" || ch=="i" || ch=="o" || ch=="u"){
        println("Given character $ch is Vowel")
    }
    else{
        println("Given character $ch is Consonants")
    }
}