fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val costs = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val dp = Array(n) { IntArray(3) }

    dp[0][0] = costs[0][0]
    dp[0][1] = costs[0][1]
    dp[0][2] = costs[0][2]

    for (i in 1 until n) {
        dp[i][0] = costs[i][0] + minOf(dp[i-1][1], dp[i-1][2])
        dp[i][1] = costs[i][1] + minOf(dp[i-1][0], dp[i-1][2])
        dp[i][2] = costs[i][2] + minOf(dp[i-1][0], dp[i-1][1])
    }

    println(minOf(dp[n-1][0], dp[n-1][1], dp[n-1][2]))
}
