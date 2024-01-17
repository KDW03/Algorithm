fun main() {
    val br = System.`in`.bufferedReader()
    val a = br.readLine()
    val b = br.readLine()
    val dp = Array(a.length + 1) { IntArray(b.length + 1) }
    for (i in 1 until a.length + 1) {
        for (j in 1 until b.length + 1) {
            if (a[i - 1] == b[j - 1]) {
                // 일치한다면  a의 i - 1 까지 b의 j - 1 까지의 최대 일치에  + 1
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                // 불 일치시 이전 까지의 최대 고려를 저장
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    println(dp[a.length][b.length])
}
