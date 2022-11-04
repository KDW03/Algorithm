const val MOD = 9901
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = Array(n+ 1) { LongArray(3) {1} }
    for (i in 2..n) {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD
    }
    println((dp[n][0] + dp[n][1] + dp[n][2]) % MOD)
}