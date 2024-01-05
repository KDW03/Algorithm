fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val str = br.readLine()

    val blueCount = str.split("B").filter { it.isNotEmpty() }.size
    val redCount = str.split("R").filter { it.isNotEmpty() }.size

    println(minOf(blueCount, redCount) + 1)
}