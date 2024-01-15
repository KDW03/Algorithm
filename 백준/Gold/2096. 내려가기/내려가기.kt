fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val maxDp = Array(n) { IntArray(3) { Int.MIN_VALUE } }
    val minDp = Array(n) { IntArray(3) { Int.MAX_VALUE } }

    fun dfs(start: Pair<Int, Int>): Pair<Int, Int> {
        val (x, y) = start
        if (x == n - 1) return Pair(arr[x][y], arr[x][y])

        if (maxDp[x][y] == Int.MIN_VALUE && minDp[x][y] == Int.MAX_VALUE) {
            val preValue = arr[x][y]
            var max = Int.MIN_VALUE
            var min = Int.MAX_VALUE
            for (ny in y - 1..y + 1) {
                val nx = x + 1
                if (ny in 0 until 3) {
                    val (nextMax, nextMin) = dfs(Pair(nx, ny))
                    max = maxOf(max, nextMax)
                    min = minOf(min, nextMin)
                }
            }
            maxDp[x][y] = preValue + max
            minDp[x][y] = preValue + min
        }

        return Pair(maxDp[x][y], minDp[x][y])
    }

    var finalMax = Int.MIN_VALUE
    var finalMin = Int.MAX_VALUE
    for (y in 0 until 3) {
        val (max, min) = dfs(Pair(0, y))
        finalMax = maxOf(finalMax, max)
        finalMin = minOf(finalMin, min)
    }

    println("$finalMax $finalMin")
}