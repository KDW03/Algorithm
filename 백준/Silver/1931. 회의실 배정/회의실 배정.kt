fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr: Array<Pair<Int, Int>> = Array(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        Pair(a, b)
    }

    var start = 0
    var count = 0
    arr.sortWith(compareBy({ it.second }, { it.first }))

    for ((s, e) in arr) {
        if (s >= start) {
            start = e
            count++
        }
    }

    println(count)
}