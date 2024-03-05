fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array(n) { Array(m) { IntArray(3) { 100001 } } }


    for (y in 0 until m) {
        for (dir in 0 until 3) {
            dp[0][y][dir] = arr[0][y]
        }
    }

    for (x in 1 until n) {
        for (y in 0 until m) {
            for (dir in 0 until 3) {
                val min = when(dir) {
                    0 -> if (y - 1 in dp[0].indices) minOf(dp[x - 1][y - 1][1],dp[x - 1][y - 1][2]) else Int.MAX_VALUE
                    1 -> minOf(dp[x - 1][y][0],dp[x - 1][y][2])
                    else -> if (y + 1 in dp[0].indices) minOf(dp[x - 1][y + 1][0],dp[x - 1][y + 1][1]) else Int.MAX_VALUE
                }
                if (min == Int.MAX_VALUE) continue
                dp[x][y][dir] = minOf(dp[x][y][dir],min + arr[x][y])
            }
        }
    }

    print(dp[n - 1].minOf { it.min() })
}