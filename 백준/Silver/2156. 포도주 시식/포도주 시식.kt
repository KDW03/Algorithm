fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val wines = IntArray(n + 1)
    for (i in 1..n) {
        wines[i] = br.readLine().toInt()
    }

    val dp = IntArray(n + 1)
    dp[1] = wines[1]
    if (n > 1) {
        dp[2] = wines[1] + wines[2]
    }

    for (i in 3..n) dp[i] = maxOf(dp[i - 1], dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i])

    println(dp[n])
}
