fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val dp = IntArray(12)
    dp[1] = 1;dp[2] = 2;dp[3] = 4
    for (i in 4..11)
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        sb.append(dp[n]).append("\n")
    }
    println(sb.toString())
}