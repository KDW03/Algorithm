const val MOD = 10007

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { IntArray(k + 1) { -1 } }
    println(answer(dp, n, k) % MOD)
}

fun answer(dp: Array<IntArray>, n: Int, k: Int): Int {
    if (k == 0 || n == k) return 1
    if (dp[n][k] == -1) dp[n][k] = (answer(dp, n - 1, k) + answer(dp, n - 1, k - 1)) % MOD
    return dp[n][k]
}