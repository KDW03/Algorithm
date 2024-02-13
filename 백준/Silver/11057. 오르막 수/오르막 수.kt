const val MOD = 10007
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val dp = Array(n + 1) { IntArray(10) { 1 } }

    // 2개 길이 부터
    for (i in 2 .. n) {
        // 끝나는 수 1부터 9까지 개수
        for (j in 1 until 10) {
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD
        }
    }

    println(dp[n].sumOf { it } % MOD)
}