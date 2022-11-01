fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = LongArray(n+1)
    dp[0] = 0;dp[1] = 1
    for (i in 2 until dp.size)
        dp[i] = dp[i-1] + dp[i-2]
    println(dp[n])
}