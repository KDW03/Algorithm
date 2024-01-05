fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val s = br.readLine().split(" ").map { it.toDouble() }.sortedDescending()

    println(s[0] + s.drop(1).sumOf { it / 2 })
}