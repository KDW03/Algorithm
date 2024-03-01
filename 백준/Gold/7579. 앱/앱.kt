
fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val memory = listOf(0) + br.readLine().split(" ").map { it.toInt() }
    val cost = listOf(0) + br.readLine().split(" ").map { it.toInt() }
    val sumCost = cost.sum()
    val dp = Array(n + 1) { IntArray(sumCost + 1) }

    var result = Int.MAX_VALUE

    for (i in 1..n) {
        val nowMemory = memory[i]
        val nowCost = cost[i]

        for (j in 0..sumCost) {
            dp[i][j] = if (j < nowCost) dp[i - 1][j] else maxOf(dp[i - 1][j], dp[i - 1][j - nowCost] + nowMemory)

            if (dp[i][j] >= m) {
                result = minOf(result, j)
            }
        }
    }

    println(result)
}
