fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k, p, x) = br.readLine().split(" ").map { it.toInt() }

    val s = listOf(
        setOf(1, 2, 3, 5, 6, 7),  // 0
        setOf(3, 6),              // 1
        setOf(2, 3, 4, 5, 7),     // 2
        setOf(2, 3, 4, 6, 7),     // 3
        setOf(1, 3, 4, 6),        // 4
        setOf(1, 2, 4, 6, 7),     // 5
        setOf(1, 2, 4, 5, 6, 7),  // 6
        setOf(2, 3, 6),           // 7
        setOf(1, 2, 3, 4, 5, 6, 7), // 8
        setOf(1, 2, 3, 4, 6, 7)   // 9
    )

    val costs = Array(10) { from ->
        IntArray(10) { to ->
            (s[from] - s[to]).size + (s[to] - s[from]).size
        }
    }


    val startX = x.toString().padStart(k, '0')
    var answer = 0
    outer@for (change in 1 .. n) {
        val c = change.toString().padStart(k,'0')
        var diff = 0
        for (i in 0 until k) {
            diff += costs[c[i].digitToInt()][startX[i].digitToInt()]
            if (diff > p) continue@outer
        }
        answer++
    }

    println(answer - 1)
}