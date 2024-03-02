fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val coins = br.readLine().split(" ").map { it.toInt() }
        val cost = br.readLine().toInt()

        val dp = IntArray(cost + 1)
        dp[0] = 1

        for (coin in coins) {
            for (j in coin .. cost) {
                dp[j] += dp[j - coin]
            }
        }

        println(dp[cost])
    }
}