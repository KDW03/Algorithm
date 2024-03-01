fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = ArrayList<Pair<Int, Int>>()
    val dp = Array(n) { IntArray(n) }
    
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        arr.add(Pair(a, b))
    }

    for (l in 1 until n) {
        for (i in 0 until n - l) {
            val j = i + l
            dp[i][j] = Int.MAX_VALUE
            for (k in i until j) {
                val cost = dp[i][k] + dp[k + 1][j] + (arr[i].first * arr[k].second * arr[j].second)
                dp[i][j] = minOf(dp[i][j], cost)
            }
        }
    }

    println(dp[0][n - 1])
}