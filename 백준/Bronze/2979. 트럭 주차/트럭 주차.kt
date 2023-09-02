fun main() {
    val br = System.`in`.bufferedReader()
    val (A, B, C) = br.readLine().split(" ").map { it.toInt() }
    val time = IntArray(101)
    var cost = 0

    repeat(3) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        for (t in start until end) time[t]++
    }

    for (t in time) {
        cost += when (t) {
            1 -> A
            2 -> 2 * B
            3 -> 3 * C
            else -> 0
        }
    }

    println(cost)
}