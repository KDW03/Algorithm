fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()

    // 최소 숫자
    val dp = LongArray(101) { -1 }

    val map = arrayOf(
        Pair(2, 1),
        Pair(3, 7),
        Pair(4, 4),
        Pair(5, 2),
        Pair(6, 0),
        Pair(7, 8),
    )

    dp[2] = 1
    dp[3] = 7
    dp[4] = 4
    dp[5] = 2
    dp[6] = 6
    dp[7] = 8

    for (i in 8 until dp.size) {
        for ((s, num) in map) {
            if (dp[i - s] != -1L) {
                if (dp[i] == -1L) {
                    dp[i] = minOf("${dp[i - s]}$num".toLong())
                } else {
                    dp[i] = minOf("${dp[i - s]}$num".toLong(), dp[i])
                }
            }
        }
    }



    repeat(t) {
        val n = br.readLine().toInt()
        val count = n / 2
        var max = ""
        if (n % 2 == 0) {
            repeat(count) {
                max += "1"
            }
        } else {
            max += "7"
            repeat(count - 1) {
                max += "1"
            }
        }
        sb.append("${dp[n]} $max").append("\n")
    }

    println(sb.toString())
}