fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val prices = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n + 1)
    
    for (i in 1..n) {
        for (j in 1..i) {
            dp[i] = maxOf(dp[i], dp[i - j] + prices[j - 1])
        }
    }

    println(dp[n])
}
