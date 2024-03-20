fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    outer@for(i in 0 until 3) {
        val n = br.readLine().toInt()
        var sum = 0

        val arr = Array(n) {
            val (coin, count) = br.readLine().split(" ").map { it.toInt() }
            sum += coin * count
            coin to count
        }

        if (sum % 2 == 1) {
            sb.append(0).append("\n")
            continue@outer
        }

        val half = sum / 2


        val dp = Array(n + 1) { IntArray(half + 1) { -1 } }

        dp[0][0] = 0

        for (x in 1 until dp.size) {
            val (coin, count) = arr[x - 1]

            for (cost in 0 until half + 1) {

                dp[x][cost] = if (dp[x - 1][cost] != -1) {
                    0
                } else if (cost - coin >= 0 && dp[x - 1][cost - coin] != -1) {
                    1
                } else if (cost - coin >= 0 && dp[x][cost - coin] != -1 && dp[x][cost - coin] < count) {
                    dp[x][cost - coin] + 1
                } else {
                    -1
                }

                if (cost == half && dp[x][cost] != -1) {
                    sb.append(1).append("\n")
                    continue@outer
                }
            }
        }

        sb.append(0).append("\n")
    }

    println(sb.toString())
}