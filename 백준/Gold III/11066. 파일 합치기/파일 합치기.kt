fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = br.readLine().toInt()
        val files = br.readLine().split(" ").map { it.toInt() }
        sb.append(mergeFiles(n,files)).append("\n")
    }
    println(sb.toString())
}

fun mergeFiles(n : Int, files : List<Int>) : Int {
    val sum = IntArray(n + 1) { 0 }
    val dp = Array(n) { IntArray(n) { 0 } }

    for (i in 1..n) {
        sum[i] = sum[i - 1] + files[i - 1]
    }


    for (d in 1 until n) {
       for (i in 0 until n - d) {
           val j = i + d
           dp[i][j] = Int.MAX_VALUE
           for (m in i until j) {
               dp[i][j] = dp[i][j].coerceAtMost(dp[i][m] + dp[m + 1][j] + sum[j + 1] - sum[i])
           }
       }
    }

    return dp[0][n - 1]
}