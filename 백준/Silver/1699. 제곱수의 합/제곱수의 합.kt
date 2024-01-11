fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[0] = 0

    for (i in 1..n) {
        var j = 1
        while (j * j <= i) {
            dp[i] = minOf(dp[i], dp[i - j * j] + 1)
            j++
        }
    }

    println(dp[n])
}