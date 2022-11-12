fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    if (n % 2 == 0)
        println("SK")
    else
        println("CY")

}
