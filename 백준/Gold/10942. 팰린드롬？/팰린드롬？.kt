fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()

    val nums = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n) { BooleanArray(n) }

    for (i in 0 until n) dp[i][i] = true
    for (i in 0 until n - 1) if (nums[i] == nums[i + 1]) dp[i][i + 1] = true


    for (len in 2 until n) {
        for (s in 0 until n - len) {
            val e = s + len
            if (nums[s] == nums[e] && dp[s + 1][e - 1]) dp[s][e] = true
        }
    }

    val m = br.readLine().toInt()
    repeat(m) {
        val (s, e) = br.readLine().split(" ").map { it.toInt() - 1 }
        sb.append(if (dp[s][e]) 1 else 0).append("\n")
    }

    print(sb.toString().trimEnd())
}