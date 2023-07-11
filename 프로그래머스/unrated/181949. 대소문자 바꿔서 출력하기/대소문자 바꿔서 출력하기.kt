fun main(args: Array<String>) {
    val s1 = readLine()!!
    val s2 = s1.map { char ->
        if(char in 'a'..'z') char.uppercase() else char.lowercase()
    }
    println(s2.joinToString(""))
}