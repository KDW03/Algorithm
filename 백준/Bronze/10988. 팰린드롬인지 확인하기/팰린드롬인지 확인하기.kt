fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    println(if (str == str.reversed()) 1 else 0)
}
