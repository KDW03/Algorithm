fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array(n) { IntArray(m) }

    dp[0][0] = board[0][0]

    for (j in 1 until m) {
        dp[0][j] = dp[0][j - 1] + board[0][j]
    }

    for (i in 1 until n) {
        dp[i][0] = dp[i - 1][0] + board[i][0]
    }

    for (i in 1 until n) {
        for (j in 1 until m) {
            dp[i][j] = maxOf(
                dp[i - 1][j], dp[i][j - 1],
                dp[i - 1][j - 1]
            ) + board[i][j]
        }
    }
    
    println(dp[n - 1][m - 1])
}